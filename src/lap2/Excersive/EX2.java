package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX2 extends GLCanvas {

	int x = 0, y = 0;
	double A = 3, B = 2;
	double R1 = 4, R2 = 2;
	int rate = 15;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);

		double t = 0;
		for (int k = 0; k < rate; k++) {
			myGL.glColor3f(1f, 0.4f, 0f);
			myGL.glBegin(GL.GL_TRIANGLE_FAN);

			myGL.glVertex2d(x + R2 * Math.cos((k + 0.5) * 2 * Math.PI / rate),
					y + R2 * Math.sin((k + 0.5) * 2 * Math.PI / rate));

			for (int i = k * 10; i < 10 * (k + 1) + 1; i++) {
				t = i * 2 * Math.PI / (rate * 10);
				myGL.glVertex2d(x + R1 * Math.cos(t), y + R1 * Math.sin(t));
			}
			myGL.glEnd();
			//
			myGL.glColor3f(0.3f, 0.4f, 0.1f);
			myGL.glBegin(GL.GL_TRIANGLE_FAN);
			myGL.glVertex2d(x + R1 * Math.cos(k * 2 * Math.PI / rate), y + R1 * Math.sin(k * 2 * Math.PI / rate));
			for (double i = (k - 0.5) * 10; i < 10 * (k + 0.5) + 1; i++) {
				t = i * 2 * Math.PI / (rate * 10);
				myGL.glVertex2d(x + R2 * Math.cos(t), y + R2 * Math.sin(t));
			}
			myGL.glEnd();
		}
		myGL.glFlush();
	}

	public void keyboard(char key, int x, int y) {
		switch (key) {
		case 'a':
			rate++;
			myUT.glutPostRedisplay();
			break;
		case 'A':
			rate--;
			myUT.glutPostRedisplay();
			break;
		case 'd':
			R1+=0.1;
			myUT.glutPostRedisplay();
			break;
		case 'D':
			R1-=0.1;
			myUT.glutPostRedisplay();
			break;
		case 'w':
			R2+=0.1;
			myUT.glutPostRedisplay();
			break;
		case 'W':
			R2-=0.1;
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
		EX2 mainCanvas = new EX2();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
