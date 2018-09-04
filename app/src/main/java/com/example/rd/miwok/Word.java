package com.example.rd.miwok;

/**
 * Created by rd on 14-07-2016.
 * vjj
 */
public class Word {
    private String mMiwokTranslation;
    private String mEnglishTranslation;
    private int mImage = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int mSound = 0;

    /*Constructor for making objects
    Two arguments
    * */
    public Word(String englishTranslation, String miwokTranslation, int Image, int Sound)
    {
        mMiwokTranslation = miwokTranslation;
        mEnglishTranslation = englishTranslation;
        mImage = Image;
        mSound = Sound;
    }
    public Word(String englishTranslation, String miwokTranslation, int Sound)
    {
        mMiwokTranslation = miwokTranslation;
        mEnglishTranslation = englishTranslation;
        mSound = Sound;

    }

    /*Get the miwok Translation of the word
    Primarily used in WordAdapter.java class which is our Custom Array Adapter
    * */
    public String getMiwokTranslation()
    {
        return mMiwokTranslation;
    }


    /*Get the english Translation of the word
    Primarily used in WordAdapter.java class which is our Custom Array Adapter
    * */
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    /*Get the image for the corresponding word
    * */
    public int getImageResourceId()
    {
        return mImage;
    }

    public int getSoundResourceId()
    {
        return mSound;
    }

    public boolean hasImage()
    {
        return mImage != NO_IMAGE_PROVIDED;
    }


}
