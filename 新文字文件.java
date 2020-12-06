package tnu.it.stu40617019.app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.jar.Attributes;

public class save extends Activity {
    ListView myListView;
    Spinner mySpinner;
    ArrayAdapter<Safety> adapter;
    String[] categories = {"All","Planets","Stars","Galaxies"};


    private void initializeViews(){
        mySpinner = findViewById(R.id.mySpinner);
        mySpinner.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,categories));

        myListView = findViewById(R.id.myListView);
        myListView.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getSafeties()));


        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long ItemID) {
                if(position >=0 && position < categories.length){
                    getSelectedCategoryData(position);
                }else{
                    Toast.makeText(save.this,"Selected Category Does not Exist!",Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                ImageView img = new ImageView(save.this);
                img.setImageResource(R.drawable.dang);
                ImageView img2 = new ImageView(save.this);
                img2.setImageResource(R.drawable.safe);
                ImageView img3 = new ImageView(save.this);
                img3.setImageResource(R.drawable.cav);
                // 顯示。
                switch(position){
                    case 0:
                        new AlertDialog.Builder(save.this)
                                .setIcon(R.drawable.choco)
                                .setTitle("巧克力")
                                .setView(img)
                                .setMessage("巧克力是以可可漿和可可脂為主要原料製成的一種甜食，巧克力製作致可劃分兩部分，一為可可豆採收，二為可可豆製作烘焙：可可豆曬乾儲存後由巧克力原料工廠採買，即開始進行加工過程，大致可依序分為烘焙、壓碎、調配與研磨、精鍊、去酸、回火鑄型等步驟。它不但口感細膩甜美，而且還具有一股濃鬱的香氣。")
                                .setNegativeButton("了解", null).create()
                                .show();
                        break;
                    case 1:
                        new AlertDialog.Builder(save.this)
                                .setIcon(R.drawable.dairy)
                                .setTitle("乳製品")
                                .setView(img2)
                                .setMessage("指的是使用牛乳或羊乳及其加工製品為主要原料，加入或不加入適量的維生素、礦物質和其他輔料，使用法律法規及標準規定所要求的條件，經加工製成的各種食品，也叫奶油製品。")
                                .setNegativeButton("了解", null).create()
                                .show();
                        break;
                    case 2:
                        new AlertDialog.Builder(save.this)
                                .setIcon(R.drawable.coke)
                                .setTitle("可樂")
                                .setView(img3)
                                .setMessage("可樂的主要口味包括香草、肉桂、檸檬香味等等由天然香料所配製出來的味道。可樂最初是由一個美國藥師約翰·彭伯頓在1886年發明的，本來是一種藥水稀釋而得到的保健飲品。")
                                .setNegativeButton("了解", null).create()
                                .show();
                        break;
                        default:
                            break;
                }
            }
        });
    }
    private ArrayList<Safety> getSafeties(){
        ArrayList<Safety> data = new ArrayList<>();
        data.clear();

        data.add(new Safety("巧克力",1));
        data.add(new Safety("UY Scuti",1));
        data.add(new Safety("可樂",3));
        data.add(new Safety("乳製品",2));
        data.add(new Safety("IC 1011",3));
        data.add(new Safety("Sun",2));
        data.add(new Safety("Aldebaran",2));
        data.add(new Safety("Venus",1));
        data.add(new Safety("Malin",3));
        data.add(new Safety("Rigel",2));
        data.add(new Safety("Earth",1));
        data.add(new Safety("Whirlpool",3));
        data.add(new Safety("VY Canis Majoris",2));
        data.add(new Safety("Saturn",1));
        data.add(new Safety("Sombrero",3));
        data.add(new Safety("Betelgeuse",2));
        data.add(new Safety("Uranus",1));
        data.add(new Safety("Virgo Stellar Stream",3));
        data.add(new Safety("Epsillon Canis Majoris",2));
        data.add(new Safety("Jupiter",1));

        return data;

    }
    private void getSelectedCategoryData(int categoryID){
        ArrayList<Safety> safeties = new ArrayList<>();
        if(categoryID == 0){
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,getSafeties());
        }else{
            for(Safety safety : getSafeties()){
                if(safety.getCategoryId() == categoryID){
                    safeties.add(safety);
                }
            }
            adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,safeties);
        }
        myListView.setAdapter(adapter);
    }
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save);

        initializeViews();
    }
}
class Safety{
    private String name;
    private int safetyID;

    public String getName(){
        return name;
    }
    public int getCategoryId(){
        return safetyID;
    }
    public Safety(String name,int safetyID){
        this.name = name;
        this.safetyID = safetyID;
    }

    @Override
    public String toString(){
        return name;
    }
}