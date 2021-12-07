package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX4c extends GLCanvas {

	int x = 0, y = 0;
	double A = 3, B = 2;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(1f, 0.4f, 0f);
		myGL.glBegin(GL.GL_TRIANGLE_STRIP);
		myGL.glVertex2f(-3, -3);
		myGL.glVertex2f(-1.5f, -3);
		myGL.glVertex2f(-1, 3);
		myGL.glVertex2f(0, 1.5f);
		myGL.glVertex2f(1, 3);
		myGL.glVertex2f(3, -3);
		myGL.glVertex2f(1.5f, -3);
		myGL.glVertex2f(0, 1.5f);
		myGL.glVertex2f(1, 0);
		myGL.glVertex2f(1, -1);
		myGL.glVertex2f(-1, -1);
		myGL.glVertex2f(-1, 0);
		myGL.glVertex2f(1, 0);
		myGL.glEnd();
		myGL.glFlush();
	}

	private void myinit() {
		/* select clearing color */
		myGL.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		/* initialize viewing values */
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGL.glOrtho(-7.0f, 7.0f, -7.0f, 7.0f, -1.0f, 1.0f);
	}

	public void init() {
		myUT.glutInitWindowSize(800, 800);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		myinit();
		myUT.glutDisplayFunc("display");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(800, 800);
		EX4c mainCanvas = new EX4c();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
