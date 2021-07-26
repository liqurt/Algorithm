package Flatten;

import java.io.*;

public class Flatten {
    public void gogogo(){
        final String inputFilePath = "./src/Flatten/input.txt";
        final File inputFile = new File(inputFilePath);
        final int BOXLENGTH = 100;
        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile));
            String str;
            try{
                boolean isDump = true;
                int testCase = 0;
                int dump = -1;
                while((str = in.readLine()) != null){
                    if(isDump){
                        dump = Integer.parseInt(str);
                    }else{
                        //입력 관련 잡다구리
                        String[] temp = str.split(" ");
                        int[] boxes = new int[BOXLENGTH];
                        for (int i=0 ; i<BOXLENGTH ; i++){
                            boxes[i] = Integer.parseInt(temp[i]);
                        }

                        //무지성 알고리즘
                        for(int i=0 ; i<dump ; i++) {
                            int min = Integer.MAX_VALUE;
                            int max = Integer.MIN_VALUE;
                            int minIndex = -1;
                            int maxIndex = -1;
                            for (int j = 0; j < BOXLENGTH; j++) {
                                // 100개중 minIndex, maxIndex를 찾는다
                                if(boxes[j]<min){
                                    min = boxes[j];
                                    minIndex=j;
                                }
                                if(boxes[j]>max){
                                    max = boxes[j];
                                    maxIndex=j;
                                }
                            }
                            boxes[minIndex]++;
                            boxes[maxIndex]--;
                        }

                        // 출력 관련 잡다구리
                        int min = Integer.MAX_VALUE;
                        int max = Integer.MIN_VALUE;
                        for (int j = 0; j < BOXLENGTH; j++) {
                            // 100개중 minIndex,maxIndex를 찾는다
                            if(boxes[j]<min){
                                min = boxes[j];
                            }
                            if(boxes[j]>max){
                                max = boxes[j];
                            }
                        }
                        System.out.println("#"+(testCase+1)+" "+(max-min));
                        testCase++;
                    }
                    isDump = !isDump;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
