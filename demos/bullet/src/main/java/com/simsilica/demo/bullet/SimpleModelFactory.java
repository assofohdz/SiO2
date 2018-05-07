/*
 * $Id$
 * 
 * Copyright (c) 2018, Simsilica, LLC
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions 
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright 
 *    notice, this list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright 
 *    notice, this list of conditions and the following disclaimer in 
 *    the documentation and/or other materials provided with the 
 *    distribution.
 * 
 * 3. Neither the name of the copyright holder nor the names of its 
 *    contributors may be used to endorse or promote products derived 
 *    from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS 
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT 
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS 
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE 
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES 
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR 
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED 
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.simsilica.demo.bullet;

import org.slf4j.*;

import com.jme3.asset.AssetManager;
import com.jme3.math.*;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.*;
import com.jme3.scene.shape.*;

import com.simsilica.es.*;
import com.simsilica.lemur.*;

/**
 *  Simple model factory implementation that uses the model ID string to
 *  create some specific test objects.
 *
 *  @author    Paul Speed
 */
public class SimpleModelFactory implements ModelFactory {

    private EntityData ed;
    private AssetManager assets;
    
    public SimpleModelFactory( EntityData ed, AssetManager assets ) {
        this.ed = ed;
        this.assets = assets;
    }

    public Spatial apply( ModelInfo modelInfo ) {
        String name = modelInfo.getModelName(ed);
        return loadModel(name);
    }
    
    public Spatial loadModel( String name ) {
    
        GuiGlobals globals = GuiGlobals.getInstance();
    
        if( "sphere".equals(name) ) {
            Sphere mesh = new Sphere(12, 12, 1);
            Geometry geom = new Geometry(name, mesh);
            geom.setMaterial(globals.createMaterial(ColorRGBA.Blue, true).getMaterial());
            geom.getMaterial().setColor("Ambient", ColorRGBA.Blue);
            geom.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
            return geom;
        } else if( "bigSphere".equals(name) ) {
            Sphere mesh = new Sphere(12, 12, 3);
            Geometry geom = new Geometry(name, mesh);
            geom.setMaterial(globals.createMaterial(ColorRGBA.Orange, true).getMaterial());
            geom.getMaterial().setColor("Ambient", ColorRGBA.Orange);
            geom.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
            return geom;
        } else if( "box".equals(name) ) {
            Box mesh = new Box(1, 1, 1);
            Geometry geom = new Geometry(name, mesh);
            geom.setMaterial(globals.createMaterial(ColorRGBA.Green, true).getMaterial());
            geom.getMaterial().setColor("Ambient", ColorRGBA.Green);
            geom.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
            return geom;
        } else if( "floor".equals(name) ) {
            Box mesh = new Box(20, 0.25f, 20);
            Geometry geom = new Geometry(name, mesh);
            geom.setMaterial(globals.createMaterial(ColorRGBA.Gray, true).getMaterial());
            geom.getMaterial().setColor("Ambient", ColorRGBA.Gray);
            geom.setShadowMode(RenderQueue.ShadowMode.Receive);
            return geom;
        } else if( "wall".equals(name) ) {
            Box mesh = new Box(10, 1, 0.25f);
            Geometry geom = new Geometry(name, mesh);
            geom.setMaterial(globals.createMaterial(ColorRGBA.Brown, true).getMaterial());
            geom.getMaterial().setColor("Ambient", ColorRGBA.Brown);
            geom.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
            return geom;
        }
        
        return null;
    }
    
}



