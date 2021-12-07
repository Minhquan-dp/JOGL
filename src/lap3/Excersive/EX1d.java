package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX1d extends GLCanvas {

	int rate = 150;
	int R = 4;
	double k = 0, g = 0;
	int t = 8;// do rong cua hinh tam giac

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);

		myGL.glBegin(GL.GL_LINE_STRIP);
		double z = 3;
		for (int i = 0; i < rate; i++) {
			myGL.glVertex3d(R * Math.cos(Math.PI * 2 * i / 50), R * Math.sin(Math.PI * 2 * i / 50), z);
			z -= 0.13;
		}
		myGL.glEnd();

		// ve truc oz
		myGL.glBegin(GL.GL_LINE_STRIP);
		myGL.glVertex3d(0, 0, 3);
		myGL.glVertex3d(0, 0, 3 - 0.13 * rate);
		myGL.glEnd();
		// ve hinh tam giac
		myGL.glColor3f(0.4f, 0.8f, 0.4f);
		myGL.glPushMatrix();
		myGL.glTranslated(0, 0, 0.13 * k);
		myGL.glRotated(g, 0, 0, 1);
		myGL.glBegin(GL.GL_TRIANGLE_FAN);
		myGL.glVertex3d(0, 0, 3);
		myGL.glVertex3d(4, 0, 3);
		myGL.glVertex3d(R * Math.cos(Math.PI * 2 * t / 50), R * Math.sin(Math.PI * 2 * t / 50), 3 - t * 0.13);
		myGL.glEnd();
		myGL.glPopMatrix();

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
		case 'y':
			k--;
			g+=7.3;
			myUT.glutPostRedisplay();
			break;
		case 'h':
			k++;
			g-=7.3;
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
		myGL.glLoadIdentity();

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
		EX1d mainCanvas = new EX1d();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
