package com.company;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.Arrays.stream;


//  NOT  ::Proje klasörünün içinde triangle.txt isimli bir txt oluşturulmalıdır Ve üçgen piramit bunun içine girilmelidir
public class Main {

    public static void main(String[] args)  {

        try {
            int[][] data = Files.lines(Paths.get("triangle.txt"))
                    .map(s -> stream(s.trim().split("\\s+"))
                            .mapToInt(Integer::parseInt)
                            .toArray())
                    .toArray(int[][]::new);

    int destination= data.length;
        for(int i=0;i< data.length;i++){
            for(int j=0;j<data[i].length;j++){
                if(asalMı(data[i][j])){
                    data[i][j]= (int) Double.NEGATIVE_INFINITY;
                }
            }
        }

        for(int i=0;i< data.length;i++){
            int sayac=0;
            for(int j=0;j<data[i].length;j++){
                if(data[i][j]<0){
                    sayac++;
                }
            }
            if(sayac ==i+1){
                destination=i;
                break;
            }
        }

        System.out.println("result "+calculate(data,destination));
        }catch (IOException e){
            System.out.println("DOSYA AÇİLMADİ (PIRAMIT OLAN DOSYANIN PROJE KLASORUNUN ICINDE OLDUGUNDAN VE ISMININ   triangle.txt  OLDUGUNDAN EMIN OLUNUZ).....");
        }


        catch (Exception e){
            System.out.println("LUTFEN DOSYAYA DUZGUN FORMATTA GIRINIZ ...");
        }
    }

    public static int calculate(int [][]data,int basla){
        for (int r = basla- 1; r > 0; r--){
            for (int c = 0; c < data[r].length - 1; c++){
                data[r - 1][c] += Math.max(data[r][c], data[r][c + 1]);
            }
        }

        if(data[0][0]<0){
            return 0;
        }
        return data[0][0];
    }

    public static boolean asalMı(int value){

        for(int i=2;i<=value/2;++i){
            if(value %i ==0){
                return false;
            }
        }

        if(value ==1 || value ==0){
            return false;
        }
        return true;
    }
}