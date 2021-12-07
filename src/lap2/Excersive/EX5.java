package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX5 extends GLCanvas {

	double R = 10;
	int rateX = 10, rateY = 20;
	int ox = 0, oy = 0;
	double denta = 2 * Math.PI / rateY;
	double beta = 2 * Math.PI / rateX;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);

		for (int k = 0; k <= rateY / 2; k++) {
			myGL.glBegin(GL.GL_LINE_LOOP);
			for (int i = 0; i < rateX; i++) {
				myGL.glVertex3d(R * Math.cos(k * Math.PI / rateY) * Math.cos(i * 2 * Math.PI / rateX),
						R * Math.sin(k * Math.PI / rateY),
						R * Math.cos(k * Math.PI / rateY) * Math.sin(i * 2 * Math.PI / rateX));
			}
			myGL.glEnd();
		}

		for (int i = 0; i < rateX / 2 + 1; i++) {
			myGL.glBegin(GL.GL_LINE_STRIP);
			for (int j = 0; j <= 2 * rateX; j++) {
				myGL.glVertex3d(R * Math.cos(j * Math.PI / rateY) * Math.cos(i * 2 * Math.PI / rateX),
						R * Math.sin(j * Math.PI / rateY),
						R * Math.cos(j * Math.PI / rateY) * Math.sin(i * 2 * Math.PI / rateX));
			}
			myGL.glEnd();
		}

		for (int i = 0; i < rateX  + 1; i++) {
			myGL.glBegin(GL.GL_LINE_STRIP);
			for (int j = 0; j <= 2 * rateX; j++) {
				myGL.glVertex3d(R * Math.cos(j * Math.PI / rateY) * Math.cos((i + j) * 2 * Math.PI / rateX),
								R * Math.sin(j * Math.PI / rateY),
								R * Math.cos(j * Math.PI / rateY) * Math.sin((i + j) * 2 * Math.PI / rateX));
			}
			myGL.glEnd();
		}
		myGL.glFlush();
	}

	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 'a':
			myGL.glRotatef(2, 1, 0, 0);
			myUT.glutPostRedisplay();
			break;
		case 's':
			myGL.glRotatef(2, 0, 1, 0);
			myUT.glutPostRedisplay();
			break;
		case 'd':
			myGL.glRotatef(2, 0, 0, 10);
			myUT.glutPostRedisplay();
			break;
		case 'A':
			myGL.glRotatef(-2, 1, 0, 0);
			myUT.glutPostRedisplay();
			break;
		case 'S':
			myGL.glRotatef(-2, 0, 1, 0);
			myUT.glutPostRedisplay();
			break;
		case 'D':
			myGL.glRotatef(-2, 0, 0, 10);
			myUT.glutPostRedisplay();
			break;

		case 27:
			System.exit(0);

		default:
			break;
		}
	}

	public void myReshape(int w, int h) {
		myGL.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
		myGL.glViewport(0, 10, w, h); /* define the viewport */ // muon quay thi phai co ham nay
		myGL.glMatrixMode(GL.GL_PROJECTION); /* prepare for and then */
		myGL.glLoadIdentity();/* define the projection */

		myGL.glOrtho(-20.0f, 20.0f, -20.0f, 20.0f, -20.0f, 20.0f);

	}

	public void init() {
		myUT.glutInitWindowSize(800, 800);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);

		myUT.glutDisplayFunc("display");
		myUT.glutKeyboardFunc("keyboard");
		myUT.glutReshapeFunc("myReshape");
		myUT.glutMainLoop();
	}

	static public void main(String args[]) throws IOException {
		Frame mainFrame = new Frame();
		mainFrame.setSize(800, 800);
		EX5 mainCanvas = new EX5();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
