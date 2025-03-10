package by.uni.lab5_navmenu;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
	Intent addEventActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		EdgeToEdge.enable(this);
		setContentView(R.layout.activity_main);
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
			Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
			return insets;
		});
//		ActivityResultLauncher<Intent> AddEventActivityLauncher = registerForActivityResult(
//				registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//					@Override
//					public void onActivityResult(ActivityResult o) {
//						if (o.getResultCode() == ActivityResult.OK) {
//							Intent data = o.getData();
//						}
//					}
//				})
//		);
		addEventActivity = new Intent(this, AddEventActivity.class);

		findViewById(R.id.buttonStartAddEventActivity).setOnClickListener(v -> {
			//AddEventActivityLauncher.launch(addEventActivity);
			startActivity(addEventActivity);
		});
	}
}