package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX4g extends GLCanvas {

	double R = 2, H = 5;
	int rate = 30;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);

		myGL.glBegin(GL.GL_TRIANGLE_FAN); // No cung theo hinh zit zat nhu TRIANGLE
		myGL.glVertex3d(0, -H, 0);
		for (int i = 0; i <= rate; i++) {
			myGL.glVertex3d(R * Math.cos(i * Math.PI * 2 / rate), 0, R * Math.sin(i * Math.PI * 2 / rate));
		}

		myGL.glEnd();

		// myGL.glScalef(1.0f, 1.0f, 1.0f); /* modeling transformation */
		// myGL.glRotatef(45, 1, 1, 1);
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
		case 'q':
			R += 0.1;
			myUT.glutPostRedisplay();
			break;
		case 'W':
			R -= 0.1;
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

		myGL.glOrtho(-7.0f, 7.0f, -7.0f, 7.0f, -7.0f, 7.0f);

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
		EX4g mainCanvas = new EX4g();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
