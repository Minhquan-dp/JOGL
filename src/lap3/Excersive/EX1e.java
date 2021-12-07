package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX1e extends GLCanvas {

	int rate = 150;

	int k = 0, g = 0;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);

		myGL.glBegin(GL.GL_LINE_STRIP);

		myGL.glEnd();
		//
		myGL.glPushMatrix();
			myGL.glTranslatef(-1, -1, 0);
			myGL.glRotatef(g, 0, 0, 1);
			myGL.glTranslatef(1, 1, 0);
			myGL.glColor3f(0.1f, 0.6f, 0.3f);
			myGL.glBegin(GL.GL_LINE_STRIP);
				myGL.glVertex2f(-1, -1);
				myGL.glVertex2f(-1, 1);
			myGL.glEnd();
			//
			myGL.glPushMatrix();
				myGL.glTranslatef(-1, 1, 0);
				myGL.glRotatef(g, 0, 0, 1);
				myGL.glTranslatef(1, -1, 0);
				myGL.glColor3f(0.7f, 0.2f, 0.3f);
				myGL.glBegin(GL.GL_LINE_STRIP);
					myGL.glVertex2f(-1, 1);
					myGL.glVertex2f(1, 1);
				myGL.glEnd();
				//
				myGL.glPushMatrix();
					myGL.glTranslatef(1, 1, 0);
					myGL.glRotatef(g, 0, 0, 1);
					myGL.glTranslatef(-1, -1, 0);
					myGL.glColor3f(0.5f, 0.5f, 0.5f);
					myGL.glBegin(GL.GL_LINE_STRIP);
						myGL.glVertex2f(1, 1);
						myGL.glVertex2f(1, -1);
					myGL.glEnd();
					//
					myGL.glPushMatrix();
						myGL.glTranslatef(1, -1, 0);
						myGL.glRotatef(g, 0, 0, 1);
						myGL.glTranslatef(-1, 1, 0);
						myGL.glColor3f(0f, 0f, 0f);
						myGL.glBegin(GL.GL_LINE_STRIP);
							myGL.glVertex2f(1, -1);
							myGL.glVertex2f(-1, -1);
						myGL.glEnd();
					myGL.glPopMatrix();
				myGL.glPopMatrix();
			myGL.glPopMatrix();
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
			g--;
			myUT.glutPostRedisplay();
			break;
		case 'h':
			k++;
			g++;
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
		EX1e mainCanvas = new EX1e();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
