package lap2.Excersive;

/*
 * hello.java
 * This is a simple, introductory OpenGL program.
 */

import java.awt.Frame;
import java.io.IOException;
import java.lang.String;
import java.lang.System;

import jgl.GL;
import jgl.GLCanvas;

public class EX3 extends GLCanvas {
	double R = 0.3;
	double X = 0, Y = 0;
	int rate = 80;

	


	public void display() {
		/* clear all pixels */
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		double z = 0.6;
		myGL.glColor3f(0f, 0f, 0f);
		myGL.glBegin(GL.GL_LINE_STRIP);
		for (int i = 0; i < rate; i++) {
			myGL.glVertex3d(R * Math.cos(i * 2 * Math.PI / 20), R * Math.sin(i * 2 * Math.PI / 20), z);
			z = z - 0.015;
		}
		myGL.glEnd();
		myGL.glScalef(1.0f, 1.0f, 1.0f); /* modeling transformation */
		myGL.glRotatef(30, 1, 0, 0);

		myGL.glFlush();

	}

	public void myReshape(int w, int h) {
		myGL.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		myGL.glViewport(0, 10, w, h); /* define the viewport */
		myGL.glMatrixMode(GL.GL_PROJECTION); /* prepare for and then */
		myGL.glLoadIdentity();/* define the projection */
		myUT.glutPostRedisplay();
		myGL.glOrtho(-1.0f, 1.0f, -1.0f, 1.0f, -1f, 1.0f);

	}

//
	/*
	 * Declare initial window size, position, and display mode (single buffer and
	 * RGBA). Open window with "hello" in its title bar. Call initialization
	 * routines. Register callback function to display graphics. Enter main loop and
	 * process events.
	 */
	public void init() {
		myUT.glutInitWindowSize(800, 800);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		;
		myUT.glutDisplayFunc("display");
		myUT.glutKeyboardFunc("keyboard");
		myUT.glutReshapeFunc("myReshape");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(800, 800);
		EX3 mainCanvas = new EX3();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
