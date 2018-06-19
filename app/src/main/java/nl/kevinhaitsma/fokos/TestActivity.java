package nl.kevinhaitsma.fokos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        List<FokosMediaType> temp = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            temp.add(new FokosMediaType().photoUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTbqxw5sGf1EVmkv3ZkPp765PDzbCBxCRYUyd1LzQVNAvUVng3v7A"));
        }

        Fokos.from(this)
                .mediaTypes(temp)
                .start();
    }
}
