package com.example.myfirstapp.Audio;

import android.content.Context;
import android.media.MediaPlayer;

import com.example.myfirstapp.R;

public class Audio_Activity_Menu_Instructions extends Audio_Abstract_Class{
    public enum MEDIA_PLAYERS
    {
        BGM_INSTRUCTIONS,
        SFX_MENU_CLICK,
    }

    public Audio_Activity_Menu_Instructions(Context theContext)
    {
        super(theContext, 1,
                R.raw.bgm_instructions_loop,
                R.raw.sfx_menu_click);
    }

    @Override
    public MediaPlayer getMediaPlayer(Object thePlayer) {
        return myPlayers[((MEDIA_PLAYERS)thePlayer).ordinal()];
    }

    @Override
    public void startMedia(Object thePlayer) {
        getMediaPlayer(thePlayer).start();
    }

    @Override
    public void stopMedia(Object thePlayer) {
        getMediaPlayer(thePlayer).stop();
    }
}
