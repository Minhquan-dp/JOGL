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

public class EX1 extends GLCanvas {
	double R = 0.5;
	double x, y;
	int rate = 80;
	double ox = 0, oy = 0;

	public void display() {
		/* clear all pixels */
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0f, 0f);
		myGL.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i < rate; i++) {
			myGL.glVertex3d(R * Math.cos(i * 2 * Math.PI / rate),R * Math.sin(i * 2 * Math.PI / rate), 0.0);
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
		EX1 mainCanvas = new EX1();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}

