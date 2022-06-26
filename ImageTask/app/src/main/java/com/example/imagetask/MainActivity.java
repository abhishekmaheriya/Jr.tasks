package com.example.imagetask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
    ImageView imageView1, imageView2, imageView3, imageView4;
    Button btnChange;
    int[] img = new int[]{R.drawable.first, R.drawable.second, R.drawable.three, R.drawable.four, R.drawable.five};
    int[] img2 = new int[]{R.drawable.first, R.drawable.second, R.drawable.three, R.drawable.four, R.drawable.five};

    ArrayList<Integer> tempArray = new ArrayList<Integer>();
    boolean isFirst = false;
    ArrayList<Integer> intArray = new ArrayList<Integer>();
    int ranInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = findViewById(R.id.img1);
        imageView2 = findViewById(R.id.img2);
        imageView3 = findViewById(R.id.img3);
        imageView4 = findViewById(R.id.img4);
        btnChange = findViewById(R.id.btnClick);

        Random random = new Random();

//        imageView1.setImageResource(img[random.nextInt(img.length)]);
////        imageView2.setImageResource(img[random.nextInt(img.length)]);
////        imageView3.setImageResource(img[random.nextInt(img.length)]);
////        imageView4.setImageResource(img[random.nextInt(img.length)]);
//        tempArray.add(imageView1);


//        int image2 = img[random.nextInt(img.length)];
//
//
////        Random random = new Random();
//        imageView1.setTag("");
//        imageView2.setTag("");
//        imageView3.setTag("");
//        imageView4.setTag("");
//
//        intArray.add(random.nextInt(img.length));
//
//        Random randomNumGenerator = new Random();
//
//        for (int idx = 1; idx <= 10; ++idx){
//            int randomInt = randomNumGenerator.nextInt(100);
//            System.out.println("Random Number= "+randomInt);
//
//        }
//
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            list.add(i);
//        }
//        Collections.shuffle(list);
//
//        // [8, 9, 7, 2, 10, 5, 3, 6, 1, 4]
//        System.out.println(list);
//
//            imageView1.setImageResource(img[list.get(0)]);
//            imageView2.setImageResource(img[list.get(1)]);
//            imageView3.setImageResource(img[list.get(2)]);
//            imageView4.setImageResource(img[list.get(3)]);
//
//
//
//        boolean check = false;

/*
        for (int i = 0; i < img.length; i++) {
            ranInt = random.nextInt(img.length);
            intArray.add(ranInt);
            System.out.println("ranInt :- " + ranInt);

//            if (imageView1.getTag().equals("") || imageView2.getTag().equals("") || imageView3.getTag().equals("") || imageView4.getTag().equals("")) {

                System.out.println("Rand Int : "+ intArray);
                for (int j = 0; j < intArray.size(); j++) {
                    if (ranInt == intArray.get(j)) {
                        ranInt = random.nextInt(img.length);
                        intArray.add(ranInt);
                        check = true;
                        continue;
                    }
                    else {
                        check = false;
                        intArray.add(ranInt);
                        break;
                    }
                }

//                if (ranInt != intArray.get(i))
//                    continue;
//                else {
                    System.out.println("I :- " + i);

                if (!check) {

                    if (imageView1.getTag().equals("")) {
                        imageView1.setImageResource(img[ranInt]);
                        imageView1.setTag("Done");
                    } else if (imageView2.getTag().equals("")) {
                        imageView2.setImageResource(img[ranInt]);
                        imageView2.setTag("Done");
                    } else if (imageView3.getTag().equals("")) {
                        imageView3.setImageResource(img[ranInt]);
                        imageView3.setTag("Done");
                    } else if (imageView4.getTag().equals("")) {
                        imageView4.setImageResource(img[ranInt]);
                        imageView4.setTag("Done");
                    }
                }
//                }
//            }
//            if (intArray.size() > 100 )
//                break;
        }
*/


            btnChange.setOnClickListener(new View.OnClickListener() {
//                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onClick(View v) {

                 /*   List<Integer> list = new ArrayList<>();
                    for (int i = 0; i < 5; i++) {
                        list.add(i);
                    }
                    Collections.shuffle(list);

                    // [8, 9, 7, 2, 10, 5, 3, 6, 1, 4]
                    System.out.println(list);

                    imageView1.setImageResource(img[list.get(0)]);
                    imageView2.setImageResource(img[list.get(1)]);
                    imageView3.setImageResource(img[list.get(2)]);
                    imageView4.setImageResource(img[list.get(3)]);*/

                    Random random = new Random();
                    ArrayList<Integer> arrayList = new ArrayList<Integer>();

                    while (arrayList.size() < 5) { // how many numbers u need - it will 6
                        int a = random.nextInt(5); // this will give numbers between 1 and 5.

                        if (!arrayList.contains(a)) {
                            arrayList.add(a);
                        }
                    }



//                    System.out.println("arrayList : " + arrayList);

                    imageView1.setImageResource(img[arrayList.get(0)]);
                    imageView2.setImageResource(img[arrayList.get(1)]);
                    imageView3.setImageResource(img[arrayList.get(2)]);
                    imageView4.setImageResource(img[arrayList.get(3)]);

                   /* int image1 = img[random.nextInt(img.length)];
                    int image2 = img[random.nextInt(img.length)];
                    int image3 = img[random.nextInt(img.length)];
                    int image4 = img[random.nextInt(img.length)];

                    for (int i = 0; i < img.length; i++)
                    {
                        imageView1.setImageResource(image1);
                        if (image1 != image2)
                        {
                            imageView2.setImageResource(image2);
                        }else
                            {
                            image2 = img[random.nextInt(img.length)];
                            imageView2.setImageResource(image2);
                        }
                        if (image3 != image1 && image3 != image2)
                        {
                            imageView3.setImageResource(image3);
                        }else
                            {
                            image3 = img[random.nextInt(img.length)];
                            imageView3.setImageResource(image3);
                        }

                        if (image4 != image1 && image4 != image3 && image4!= image2)
                        {
                            imageView4.setImageResource(image4);
                        }else
                            {
                            image4 = img[random.nextInt(img.length)];
                            imageView4.setImageResource(image4);
                        }
//                        imageView3.setImageResource(image3);
//                        imageView4.setImageResource(image4);

                    }*/
                }

                    /*Random rng = new Random();
                    List<Integer> generated = new ArrayList<Integer>();
                    for (int i = 0; i < 5; i++)
                    {
                        while(true)
                        {
                            Integer next = rng.nextInt(5) ;
                            if (!generated.contains(next))
                            {
                                generated.add(next);
                                ImageView iv = (ImageView)findViewById(img2[i]);
                                iv.setImageResource(img[next]);
                                break;
                            }
                        }
                    }*/
//                    Random random = new Random();
              /*  ArrayList<Integer> list1 = new ArrayList<Integer>();
                ArrayList<Integer> list2 = new ArrayList<Integer>();

                imageView1.setTag("");
                imageView2.setTag("");
                imageView3.setTag("");
                imageView4.setTag("");

             int temp = random.nextInt(img.length);

             if (!isFirst) {
                 tempArray.add(temp);
             }
             isFirst = true;
                for (int i = 0; i < tempArray.size(); i++) {
                    if (temp!=tempArray.get(i))
                    {
                        tempArray.add(temp);
                        if (temp==0 && !imageView1.getTag().equals("Done")) {
                            imageView1.setImageResource(img[temp]);
                            imageView1.setTag("Done");
                        }
                        else if (temp==1 && !imageView2.getTag().equals("Done")) {
                            imageView2.setImageResource(img[temp]);
                            imageView2.setTag("Done");
                        }
                        else if (temp==2 && !imageView3.getTag().equals("Done")) {
                            imageView3.setImageResource(img[temp]);
                            imageView3.setTag("Done");
                        }
                        else if (temp==3 && !imageView4.getTag().equals("Done")) {
                            imageView4.setImageResource(img[temp]);
                            imageView4.setTag("Done");
                        }
                    }
                }*/

              /*  imageView1.setImageResource(img[random.nextInt(img.length)]);
                imageView2.setImageResource(img[random.nextInt(img.length)]);
                imageView3.setImageResource(img[random.nextInt(img.length)]);
                imageView4.setImageResource(img[random.nextInt(img.length)]);

                int randInts [] = random.ints(0, img.length).distinct().limit(4).toArray();

                imageView1.setImageResource(img[randInts[0]]);
                imageView2.setImageResource(img[randInts[1]]);
                imageView3.setImageResource(img[randInts[2]]);
                imageView4.setImageResource(img[randInts[3]]);
*/
//                int temp = random.nextInt(img.length);

//                return;

           /*  int img1 = list1.get(random.nextInt(list1.size()));
                for (int i = 0; i<list2.size(); i++) {
                    if (list2.contains(img1)) {
                        img1 = list1.get(random.nextInt(list1.size()));
                        imageView1.setImageResource(img1);
                    } else {
                        imageView1.setImageResource(img1);
                    }

                    list1.add(img1);

                    int img2 = list1.get(random.nextInt(list1.size()));
                    if (list2.contains(img2)){
                        img2 = list1.get(random.nextInt(list1.size()));
                        imageView2.setImageResource(img2);
                    }else {
                        imageView2.setImageResource(img2);
                    }

                    int img3 = list1.get(random.nextInt(list1.size()));
                    if (list2.contains(img3)){
                        img3 = list1.get(random.nextInt(list1.size()));
                        imageView2.setImageResource(img3);
                    }else {
                        imageView2.setImageResource(img3);
                    }


                    int img4 = list1.get(random.nextInt(list1.size()));
                    if (list2.contains(img4)){
                        img4 = list1.get(random.nextInt(list1.size()));
                        imageView2.setImageResource(img4);
                    }else {
                        imageView2.setImageResource(img4);
                    }


                }*/


//                getRandomImages(list1,5);


//                for (int i = 0; i<5; i++){
//                    int next = random.nextInt(4)+1;
//                    if (!list1.contains(next)){
//                        list1.add(img[next]);
//                        list2.add(img2[next]);
//                        break;
//                    }
//                }
//
//                img = getRandomImages(list1);
//                img2 = getRandomImages(list2);

//                Random rng = new Random();
//                List<Integer> generated = new ArrayList<Integer>();
//
//                for (int i = 0;  i<5; i++){
//                    Integer next = rng.nextInt(5);
//                    if (!generated.contains(next)){
//                        generated.add(next);
//                        ImageView iv = (ImageView) findViewById(img2[i]);
//                        iv.setImageResource(img[next]);
//                        break;
//                    }
//                }




            });

        }

//    public int[] getRandomImages(ArrayList<Integer> list){
//        list.add(R.drawable.first);
//        list.add(R.drawable.second);
//        list.add(R.drawable.three);
//        list.add(R.drawable.four);
//        list.add(R.drawable.five);
//
//        int[] repeat = new int[list.size()];
//        Iterator<Integer> iterator = list.iterator();
//        for (int i = 0; i < repeat.length; i++)
//        {
//            repeat[i] = iterator.next().intValue();
//        }
//        return repeat;

        /*Random rand = new Random();
        List<Integer> newList = new ArrayList<>();
        list.add(R.drawable.first);
        list.add(R.drawable.second);
        list.add(R.drawable.three);
        list.add(R.drawable.four);
        list.add(R.drawable.five);

        for (int i = 0; i<totalImages; i++)
        {
            int img1 = list.get(rand.nextInt(list.size()));
            if (newList.contains(img1)) {
                img1 = list.get(rand.nextInt(list.size()));
                imageView1.setImageResource(img1);
            } else {
                imageView1.setImageResource(img1);
            }
            newList.add(img1);

            int img2 = list.get(rand.nextInt(list.size()));
            if (newList.contains(img2)) {
                img2 = list.get(rand.nextInt(list.size()));
                imageView2.setImageResource(img2);
            } else {
                imageView2.setImageResource(img2);
            }
            newList.add(img2);


            int img3 = list.get(rand.nextInt(list.size()));
            if (newList.contains(img3)) {
                img3 = list.get(rand.nextInt(list.size()));
                imageView3.setImageResource(img3);
            } else {
                imageView3.setImageResource(img3);
            }
            newList.add(img3);


            int img4 = list.get(rand.nextInt(list.size()));
            if (newList.contains(img4)) {
                img4 = list.get(rand.nextInt(list.size()));
                imageView4.setImageResource(img4);
            } else {
                imageView4.setImageResource(img4);
            }
            newList.add(img4);

        }*/

    }
