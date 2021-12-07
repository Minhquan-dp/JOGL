package lap2.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

/*
 * Hinh nay em ve tren 0XYZ nhuwng ma khoi dau nhin giong 2d, thay nhan phim a, s de hinh xoay nha thay
 */

public class EX4e extends GLCanvas {
/**
 * cach 1: use TRIANGLE
 */
	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);

		myGL.glBegin(GL.GL_TRIANGLE_STRIP);

		myGL.glVertex3d(1, 2, 1);
		myGL.glVertex3d(1, 2, -1);
		myGL.glVertex3d(2, 0, 1);
		myGL.glVertex3d(2, 0, -1);
		myGL.glVertex3d(1, -2, 1);
		myGL.glVertex3d(1, -2, -1);
		myGL.glVertex3d(-1, -2, 1);
		myGL.glVertex3d(-1, -2, -1);
		myGL.glVertex3d(-2, 0, 1);
		myGL.glVertex3d(-2, 0, -1);
		myGL.glVertex3d(-1, 2, 1);
		myGL.glVertex3d(-1, 2, -1);
		myGL.glVertex3d(1, 2, 1);
		myGL.glVertex3d(1, 2, -1);
		myGL.glEnd();

		// myGL.glScalef(1.0f, 1.0f, 1.0f); /* modeling transformation */
		// myGL.glRotatef(45, 1, 1, 1);
		myGL.glFlush();
	}
	/**
	 * cach 2 : use QUAD
	 */
//	public void display() {
//		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
//		myGL.glColor3f(0f, 0.0f, 0f);
//
//		myGL.glBegin(GL.GL_QUAD_STRIP); // No cung theo hinh zit zat nhu TRIANGLE
//
//		myGL.glVertex3d(1, 2, 1);
//		myGL.glVertex3d(1, 2, -1);
//		myGL.glVertex3d(2, 0, 1);
//		myGL.glVertex3d(2, 0, -1);
//		myGL.glVertex3d(1, -2, 1);
//		myGL.glVertex3d(1, -2, -1);
//		myGL.glVertex3d(-1, -2, 1);
//		myGL.glVertex3d(-1, -2, -1);
//		myGL.glVertex3d(-2, 0, 1);
//		myGL.glVertex3d(-2, 0, -1);
//		myGL.glVertex3d(-1, 2, 1);
//		myGL.glVertex3d(-1, 2, -1);
//		myGL.glVertex3d(1, 2, 1);
//		myGL.glVertex3d(1, 2, -1);
//		myGL.glEnd();
//
//		// myGL.glScalef(1.0f, 1.0f, 1.0f); /* modeling transformation */
//		// myGL.glRotatef(45, 1, 1, 1);
//		myGL.glFlush();
//	}

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

		default:
			break;
		case 27:
			System.exit(0);
			
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
		EX4e mainCanvas = new EX4e();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
