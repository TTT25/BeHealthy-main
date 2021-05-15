package com.fatguy.behealthy;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.L;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class TopBarMainFragment extends Fragment {
    private View root;
    private ImageView Logout;
    private FirebaseAuth mAuth;
    private ImageView avatar;
    Bitmap bitmap;

    private final String TAG = "java.StorageActivity";
    Uri imageUri;
    private static final int IMAGE_REQUEST =2;

    public TopBarMainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_top_bar_main, container, false);
        Logout = root.findViewById(R.id.top_btnMore);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getContext(), LoginActivity.class));

            }
        });
        avatar = root.findViewById(R.id.btnAvatar);
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImage();


            }
        });

        return root;
    }
    private void openImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,IMAGE_REQUEST);

    }

    private void uploarImage() {
        final ProgressDialog pd= new ProgressDialog(getContext());
        pd.setMessage("Up");
        pd.show();
        if(imageUri!=null )
        {
            StorageReference fileRef = FirebaseStorage.getInstance().getReference().child("Imager").child(System.currentTimeMillis()+"."+getfileExtension(imageUri));
            fileRef.putFile(imageUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull @NotNull Task<UploadTask.TaskSnapshot> task) {
                    fileRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            String url = uri.toString();
                            Log.d("DownloadUrl ",url);
                            pd.dismiss();
                            Toast.makeText(getContext(),"Upload succescfull",Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            });


        }else     Toast.makeText(getContext(),"Fail",Toast.LENGTH_SHORT).show();
    }

    private String getfileExtension(Uri imageUri) {


        ContentResolver contentResolver = getContext().getContentResolver();
        MimeTypeMap mimeTypeMap = MimeTypeMap.getSingleton();

        return mimeTypeMap.getExtensionFromMimeType(contentResolver.getType(imageUri));
    }
    public void onActivityResult(int RequestCode ,int resultCode, Intent data) {
        super.onActivityResult(RequestCode,resultCode, data);
        if (RequestCode== IMAGE_REQUEST && resultCode == RESULT_OK )
        {

            imageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(),imageUri);
                avatar.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
            uploarImage();

        }
    }


}