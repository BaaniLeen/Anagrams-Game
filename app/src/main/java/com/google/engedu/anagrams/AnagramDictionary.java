/* Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.engedu.anagrams;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();
    private final String TAG = "GoogleCSWithAndroid";
    private HashSet<String> wordSet = new HashSet<String>();
    private HashMap<String, ArrayList> lettersToWord = new HashMap<String, ArrayList>();
    private HashSet<String> word_morethan5anagrams = new HashSet<String>();

    public AnagramDictionary(Reader reader) throws IOException {
        BufferedReader in = new BufferedReader(reader);
        String line;
//        wordSet = new HashSet<String>();
        while ((line = in.readLine()) != null) {
            String word = line.trim();
            wordSet.add(word);
        }
        //Log.d(TAG,String.valueOf(wordList.size()));
    }

    public boolean isGoodWord(String word, String base) {
//        if (wordSet.contains(word) && !(word.contains(base))){
//            return true;
//        }
//        else{
//            return false;
//        }
        return true;
    }

    public List<String> getAnagrams(String targetWord) {

        ArrayList<String> result = new ArrayList<String>();
        for (String s : wordSet) {
            String a = Sort_str(s);
            String b = Sort_str(targetWord);
            if (a.equals(b) && s!=targetWord) {
                result.add(s);
            }
        }
        lettersToWord.put(Sort_str(targetWord), result);
        for (String s : lettersToWord.keySet()) {
            for (String sa : result) {
                Log.d(TAG, sa);
            }
        }
        return result;
    }

    public String Sort_str(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

//    public List<String> getAnagrams(String word) {
//        ArrayList<String> result = new ArrayList<String>();
//        for (String s : wordSet) {
//            int[] a1 = freq(s);
//            int[] a2 = freq(word);
//            int c = 0;
//            for (int i = 0; i < 26; i++) {
//                if (a1[i] != a2[i] && a1[i]-a2[i]==1) {
//                    c++;
//                }
//            }
//            if (c == 1) result.add(s);
//        }
//
//        lettersToWord.put(Sort_str(word), result);
//        for (String s : lettersToWord.keySet()) {
//            for (String sa : result) {
//                Log.d(TAG, sa);
//            }
//        }
//
//        return result;
//    }

    public int[] freq(String w) {
        int f;
        w = w.toLowerCase();
        char[] c = w.toCharArray();
        int a[] = new int[26];
        for (char s : c) {
            a[(int) s - 97] += 1;
        }
        return a;
    }


    public String pickGoodStarterWord() {
        Random rand=new Random();
        for (String s : wordSet) {
            if((getAnagrams(s)).size() >= MIN_NUM_ANAGRAMS)
            {
                word_morethan5anagrams.add(s);
            }
        }



//        int c = 0;
//        List<String> list = new ArrayList<String>(wordSet);
//        String w = list.get(rand.nextInt(list.size()));
//        while(1==1) {
//
//            if ((getAnagrams(w)).size() > 1) {
//                Log.d(TAG, getAnagrams(w).toString());
//                return w;
//            }

        }
    }

}

