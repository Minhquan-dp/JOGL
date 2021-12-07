package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX4h extends GLCanvas {

	double R = Math.sqrt(106), H = 5;
	int rate = 30;
	int ox = 6, oy = 8;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);

		// cau thang
		myGL.glBegin(GL.GL_LINES);
		myGL.glVertex3f(-3, 3, 1);
		myGL.glVertex3f(-3, -3, 1);
		myGL.glEnd();

		myGL.glBegin(GL.GL_LINES);
		myGL.glVertex3f(-3, 3, -1);
		myGL.glVertex3f(-3, -3, -1);
		myGL.glEnd();

		for (int i = -2; i < 4; i++) {
			myGL.glBegin(GL.GL_LINES);
			myGL.glVertex3f(-3, i, 1);
			myGL.glVertex3f(-3, i, -1);
			myGL.glEnd();
		}
		// cau truoc
		myGL.glBegin(GL.GL_QUAD_STRIP);
		for (int i = 0; i < 8; i++) {
			myGL.glVertex3d(ox + R * Math.cos(Math.PI + Math.PI / 6.3 + i * Math.PI * 2 / 50),
					oy + R * Math.sin(Math.PI + Math.PI / 6.3 + i * Math.PI * 2 / 50), 1);
			myGL.glVertex3d(ox + R * Math.cos(Math.PI + Math.PI / 6.3 + i * Math.PI * 2 / 50),
					oy + R * Math.sin(Math.PI + Math.PI / 6.3 + i * Math.PI * 2 / 50), -1);
		}
		myGL.glEnd();

		// thanh de
		myGL.glBegin(GL.GL_QUAD_STRIP);	
		myGL.glVertex3d(4, -2, 1);
		myGL.glVertex3d(4, -2, -1);
		myGL.glVertex3d(4, -3, 1);
		myGL.glVertex3d(4, -3, -1);
		myGL.glEnd();
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

		myGL.glOrtho(-10.0f, 10.0f, -10.0f, 10.0f, -10.0f, 10.0f);

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
		EX4h mainCanvas = new EX4h();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
