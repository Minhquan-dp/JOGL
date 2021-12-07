package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX1c extends GLCanvas {

	int rate = 150;
	int R = 4;
	double k = 0, g = 0;
	int t = 0;
	double h = 3;// do cao cua hinh tron

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

		// ve hinh cau
		myGL.glColor3f(1f, 0.7f, 0f);
		myGL.glPushMatrix();
		myGL.glTranslated(R * Math.cos(Math.PI * 2 * t / 50), R * Math.sin(Math.PI * 2 * t / 50), h);
		myGL.glRotated(4, 0, 0, 1);

		myUT.glutWireSphere(1, 10, 10);

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
			t++;
			h -= 0.13;
			System.out.println(k);
			myUT.glutPostRedisplay();
			break;
		case 'h':
			t--;
			h += 0.13;
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
		EX1c mainCanvas = new EX1c();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
