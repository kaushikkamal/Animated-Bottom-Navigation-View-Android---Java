package in.kaushik.animatedbottomnavigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

	BottomNavigationView navigation;
	FrameLayout main_container;
	Fragment active;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		main_container = findViewById(R.id.main_container);
		navigation = findViewById(R.id.navigation);
		final Fragment fragment1 = new HomeFrag();
		final Fragment fragment2 = new UserProfileFrag();
		final FragmentManager fm = getSupportFragmentManager();
		active = fragment1;

		fm.beginTransaction().add(R.id.main_container, fragment2, "2").hide(fragment2).commit();
		fm.beginTransaction().add(R.id.main_container, fragment1, "1").commit();

		navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item) {
				switch (item.getItemId()) {
					case R.id.navigation_home:
						fm.beginTransaction().hide(active).show(fragment1).commit();
						active = fragment1;
						return true;
					case R.id.navigation_profile:
						fm.beginTransaction().hide(active).show(fragment2).commit();
						active = fragment2;
						return true;
				}
				return false;
			}
		});
	}
}