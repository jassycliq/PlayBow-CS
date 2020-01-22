package com.jassycliq.playbowcs.activity.ui.ownership;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jassycliq.playbowcs.R;
import com.jassycliq.playbowcs.UserProfile;
import com.jassycliq.playbowcs.activity.data.model.OwnershipModel;
import com.jassycliq.playbowcs.activity.ui.SharedViewModel;

import org.jetbrains.annotations.NotNull;

import static com.jassycliq.playbowcs.utils.Constants.DATABEAN;
import static com.jassycliq.playbowcs.utils.Constants.FIRST_RUN;
import static com.jassycliq.playbowcs.utils.Constants.SHARED_PREF;

public class OwnershipFragment extends Fragment {
    private SwipeRefreshLayout swipeContainer;
    private RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    private UserProfile mBinding;
    private SharedPreferences sharedPreferences;
    private static FragmentManager fragmentManager;

    private OwnershipViewModel ownershipViewModel;
    private static SharedViewModel sharedViewModel;

    public static OwnershipFragment newInstance() {
        return new OwnershipFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.recycler_view_ownership_items, container, false);
        return inflater.inflate(R.layout.fragment_ownership, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.ownership_recycler_view);
        swipeContainer = view.findViewById(R.id.ownership_swipe_refresh);
        floatingActionButton = view.findViewById(R.id.fragment_ownership_floating_action_button);
        sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREF, Context.MODE_PRIVATE);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);
        ownershipViewModel = ViewModelProviders.of(this).get(OwnershipViewModel.class);
        fragmentManager = getFragmentManager();

        recyclerView.setAdapter(ownershipViewModel.getAdapter());
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(() -> {
            ownershipViewModel.getUsers(swipeContainer);
        });

        ownershipViewModel.getOwnershipResult().observe(this, ownershipResult -> {
            if (ownershipResult == null) {
                return;
            }
            if (ownershipResult.getFailure() != null) {
                SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
                prefsEditor.putString(DATABEAN, null);
                prefsEditor.putBoolean(FIRST_RUN, true);
                prefsEditor.apply();

                Navigation.findNavController(requireActivity(), R.id.container).navigate(R.id.action_homeFragment_to_loginActivity);
            }
        });

        floatingActionButton.setOnClickListener(v -> {
            composeEmail(ownershipViewModel.getActiveUsers(), "PlayBow Test");
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener(){
            @Override
            public void onScrolled(@NotNull RecyclerView recyclerView, int dx, int dy){
                if (dy > 0)
                    floatingActionButton.hide();
                else if (dy < 0)
                    floatingActionButton.show();
            }
        });

        ownershipViewModel.getUsers(swipeContainer);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NotNull Menu menu, @NotNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();

        inflater.inflate(R.menu.main_menu, menu);
        final MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW | MenuItem.SHOW_AS_ACTION_IF_ROOM);

        final SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                ownershipViewModel.searchItem(query);
                recyclerView.scrollToPosition(0);
                return true;
            }
        });
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        private UserProfile mBinding;

        public UserViewHolder(UserProfile binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        public void bind(OwnershipModel.UserProfile item) {
            mBinding.setModel(item);
            mBinding.homeActivityOnClickView.setOnClickListener(v -> {
                sharedViewModel.select(item);
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_userProfileFragment);
            });
            mBinding.executePendingBindings();
        }
    }

    public void composeEmail(String[] addresses, String subject) {
        if (addresses != null) {
            String[] playbowEmail = {"woof@playbowdogs.com"};
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_EMAIL, playbowEmail);
            intent.putExtra(Intent.EXTRA_BCC, addresses);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            Toast.makeText(requireContext(), "No users loaded yet!", Toast.LENGTH_SHORT).show();
        }
    }
}
