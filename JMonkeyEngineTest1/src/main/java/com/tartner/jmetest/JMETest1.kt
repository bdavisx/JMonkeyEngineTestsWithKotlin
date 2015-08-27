package com.tartner.jmetest

import com.jme3.app.SimpleApplication
import com.jme3.material.Material
import com.jme3.math.ColorRGBA
import com.jme3.math.Vector3f
import com.jme3.scene.Geometry
import com.jme3.scene.shape.Box

public class Main : SimpleApplication() {

    override fun simpleInitApp() {
        val box = Box(Vector3f.ZERO, 1f, 1f, 1f);

        val geometry = Geometry("Box", box);

        // create a simple blue material
        val material = Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Blue);
        // give the object the blue material
        geometry.setMaterial(material);
        // make the object appear in the scene
        rootNode.attachChild(geometry);
    }

}

fun main(args: Array<String>) {
    val main = Main()
    main.start()
}
