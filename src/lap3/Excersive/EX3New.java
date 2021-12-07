package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.event.ChangeListener;

import jgl.GL;
import jgl.GLCanvas;
import jgl.context.attrib.gl_lighting;
import jgl.*;

public class EX3New extends GLCanvas {

	private int elbowRightCornerX;

	private int elbowRightCornerZ = 0;
	private int armRightCornerX = 0;
	private int armRightCornerY = 0;
	private int armRightCornerZ = 0;
	private int handRightCornerX = 0;
	private int fingerRightCorner = 0;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(1, 1, 1);

		
		myGL.glPushMatrix();
		myGL.glTranslated(-1, 0, 0);
	//	myGL.glRotatef((float) , , armRightCornerY, armRightCornerX);
		
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

		// canh tay
		case 'q':
			if (armRightCornerX < 90)
				armRightCornerX += 5;

			myUT.glutPostRedisplay();
			break;
		case 'Q':
			if (armRightCornerX > -30)
				armRightCornerX -= 5;
			myUT.glutPostRedisplay();
			break;
		case 'w':
			if (armRightCornerY < 180)
				armRightCornerY += 5;
			myUT.glutPostRedisplay();
			break;

		case 'W':
			if (armRightCornerY > -45)
				armRightCornerY -= 5;
			myUT.glutPostRedisplay();
			break;

		case 'e':
			if (armRightCornerZ < 135)
				armRightCornerZ += 5;
			myUT.glutPostRedisplay();
			break;

		case 'E':
			if (armRightCornerZ > 0)
				armRightCornerZ -= 5;
			myUT.glutPostRedisplay();
			break;

		// Khuyu tay
		case 'r':
			if (elbowRightCornerX > -80)
				elbowRightCornerX -= 5;
			myUT.glutPostRedisplay();
			break;
		case 'R':
			if (elbowRightCornerX < 0)
				elbowRightCornerX += 5;
			myUT.glutPostRedisplay();
			break;

		case 't':
			if (elbowRightCornerZ > -125)
				elbowRightCornerZ -= 5;
			myUT.glutPostRedisplay();
			break;
		case 'T':
			if (elbowRightCornerZ < 0)
				elbowRightCornerZ += 5;
			myUT.glutPostRedisplay();
			break;

		case 'z':
			handRightCornerX += 5;
			myUT.glutPostRedisplay();
			break;

		case 'x':
			fingerRightCorner += 5;
			myUT.glutPostRedisplay();
			break;
		case 27:
			System.exit(0);

		default:
			break;
		}
	}

	public void paintBoxShape() {
		myGL.glPushMatrix();

		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(1, 1, 1);
		myGL.glVertex3d(1, -1, 1);
		myGL.glVertex3d(-1, -1, 1);
		myGL.glVertex3d(-1, 1, 1);
		myGL.glEnd();

		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(1, 1, 1);
		myGL.glVertex3d(1, -1, 1);
		myGL.glVertex3d(1, -1, -1);
		myGL.glVertex3d(1, 1, -1);
		myGL.glEnd();

		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(1, 1, -1);
		myGL.glVertex3d(1, -1, -1);
		myGL.glVertex3d(-1, -1, -1);
		myGL.glVertex3d(-1, 1, -1);
		myGL.glEnd();

		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(-1, 1, 1);
		myGL.glVertex3d(-1, -1, 1);
		myGL.glVertex3d(-1, -1, -1);
		myGL.glVertex3d(-1, 1, -1);
		myGL.glEnd();

		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(1, 1, 1);
		myGL.glVertex3d(1, 1, -1);
		myGL.glVertex3d(-1, 1, -1);
		myGL.glVertex3d(-1, 1, 1);
		myGL.glEnd();

		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(1, -1, 1);
		myGL.glVertex3d(1, -1, -1);
		myGL.glVertex3d(-1, -1, -1);
		myGL.glVertex3d(-1, -1, 1);
		myGL.glEnd();

		myGL.glPopMatrix();
		myGL.glFlush();
	}

	public void myReshape(int w, int h) {
		myGL.glClearColor(0, 0, 0, 0.0f);
		myGL.glViewport(0, 10, w, h); /* define the viewport */ // muon quay thi phai co ham nay
		myGL.glMatrixMode(GL.GL_PROJECTION); /* prepare for and then */
		myGL.glLoadIdentity();/* define the projection */
		myGL.glOrtho(-20.0f, 20.0f, -20.0f, 20.0f, -20.0f, 20.0f);
		myGL.glMatrixMode(GL.GL_MODELVIEW); /* prepare for and then */
		myGL.glLoadIdentity();
//		myGL.glEnable(GL.GL_LIGHTING);
//		myGL.glEnable(GL.GL_LIGHT0);
//		myGL.glEnable(GL.GL_DEPTH_TEST);

		
		
//		myGL.GL_FLOAT[] ambient = { 1.0f, 0.0f, 0.0f, 1.0f };
//		glMaterialfv(GL_FRONT_AND_BACK, GL_AMBIENT, ambient);
//
//		GLfloat diff_use[] = { 0.0, 0.5, 0.0, 1.0 };
//		glMaterialfv(GL_FRONT_AND_BACK, GL_DIFFUSE, diff_use);
//
//		float specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
//		glMaterialfv(GL.GL_FRONT_AND_BACK, GL.GL_SPECULAR, specular);
//
//		myGL.GLfloat shininess = 50.0f;
//		glMateriali(GL_FRONT, GL_SHININESS, shininess);

		// myGL.glEnable(GL.GL_DIFFUSE);
//		myGLU.gluLookAt( 0.0, 0.0, 7.0, 
//				 0.0, 0.0, 0.0, 
//				 0.0, 1.0, 0.0 );

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
		EX3New mainCanvas = new EX3New();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
