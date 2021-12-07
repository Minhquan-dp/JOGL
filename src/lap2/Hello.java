package lap2;
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

public class Hello extends GLCanvas {
	double R1 = 0.5,R2=0.3;
	double x, y;
	int rate = 80;
	double ox = 0, oy = 0;

	public void display() {
		/* clear all pixels */
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);

		/*
		 * draw white polygon (rectangle) with corners at (0.25, 0.25, 0.0) and (0.75,
		 * 0.75, 0.0)
		 */
		myGL.glColor3f(0f, 0f, 0f);
		myGL.glBegin(GL.GL_LINE_LOOP);
//		myGL.glVertex3f(0.25f, 0.25f, 0.0f);
//		myGL.glVertex3f(0.75f, 0.25f, 0.0f);
//		myGL.glVertex3f(0.75f, 0.75f, 0.0f);
//		myGL.glVertex3f(0.25f, 0.75f, 0.0f);
		for (int i = 0; i < rate; i++) {
			myGL.glVertex3d(R1 * Math.cos(i * 2 * Math.PI / rate),R1 * Math.sin(i * 2 * Math.PI / rate), 0.0);
		}
		myGL.glEnd();
		
		myGL.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i < rate; i++) {
			myGL.glVertex3d(R2 * Math.cos(i * 2 * Math.PI / rate),R2 * Math.sin(i * 2 * Math.PI / rate), 0.0);
		}
		myGL.glEnd();
		
		
		/*
		 * don't wait! start processing buffered OpenGL routines
		 */
		myGL.glFlush();
	}

	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 'a':
			rate++;
			myUT.glutPostRedisplay();
			break;
		case 'd':
			rate--;
			myUT.glutPostRedisplay();
			break;
		default:
			break;
		}
	}

	private void myinit() {
		/* select clearing color */
		myGL.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);

		/* initialize viewing values */
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGL.glOrtho(-1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f);
	}

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
		myinit();
		myUT.glutDisplayFunc("display");
		myUT.glutKeyboardFunc("keyboard");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(800, 800);
		Hello mainCanvas = new Hello();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
