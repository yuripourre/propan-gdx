package com.harium.propan;

import com.harium.etyl.DesktopEngine;
import com.harium.etyl.core.Core;
import com.harium.etyl.core.Engine;
import com.harium.etyl.loader.FontLoader;
import com.harium.etyl.loader.MultimediaLoader;
import com.harium.etyl.loader.image.ImageLoader;
import com.harium.etyl.util.PathHelper;
import com.harium.propan.core.CoreGL;
import com.harium.propan.core.context.ApplicationGL;
import com.harium.propan.core.loader.MeshLoader;

public abstract class Propan extends DesktopEngine implements Engine<ApplicationGL> {

    private ApplicationGL application;

    public Propan(int w, int h) {
        super(w, h);
    }

    public void init() {
        initialSetup("");

        application = startApplication();
        application.setLoaded(false);
        core.setApplication(application);

        super.init();
    }

    protected Core initCore() {
        return new CoreGL(w, h);
    }

    protected void initialSetup(String suffix) {
        String path = PathHelper.currentDirectory() + "assets/" + suffix;

        ImageLoader.getInstance().setPath(path);
        FontLoader.getInstance().setPath(path);
        MultimediaLoader.getInstance().setPath(path);
        MeshLoader.getInstance().setPath(path);
    }

}
