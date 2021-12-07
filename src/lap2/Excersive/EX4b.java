package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX4b extends GLCanvas {

	double A = 4, B = 2.5;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(1f, 0.4f, 0f);
		myGL.glBegin(GL.GL_LINE_LOOP);
		for (int i = 0; i < 31; i++) {
			myGL.glVertex2d(A * Math.cos(i * 2 * Math.PI / 30), B * Math.sin(i * 2 * Math.PI / 30));
		}
		myGL.glEnd();
		myGL.glFlush();
	}

	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 'a':
			A += 0.1;
			myUT.glutPostRedisplay();
			break;

		case 'd':
			A -= 0.1;
			myUT.glutPostRedisplay();
			break;

		case 'w':
			B += 0.1;
			myUT.glutPostRedisplay();
			break;

		case 's':
			B -= 0.1;
			myUT.glutPostRedisplay();
			break;
		case 27:
			System.exit(0);
			
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
		myGL.glOrtho(-7.0f, 7.0f, -7.0f, 7.0f, -1.0f, 1.0f);
	}

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
		EX4b mainCanvas = new EX4b();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
