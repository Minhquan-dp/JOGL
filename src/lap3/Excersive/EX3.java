package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import javax.swing.event.ChangeListener;

import jgl.GL;
import jgl.GLCanvas;

public class EX3 extends GLCanvas {

	private int elbowRightCornerX;

	private int elbowRightCornerZ = 0;
	private int armRightCornerX = 0;
	private int armRightCornerY = 0;
	private int armRightCornerZ = 0;
	private int handRightCornerX = 0;
	private int fingerRightCorner = 0;
	
	private int bapde = 0;
	private int bapcang = 0;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(1, 1, 1);

		myGL.glPushMatrix();// all body
		// Phan than
			myGL.glPushMatrix();
			myGL.glScaled(6, 10, 3);
			myUT.glutWireCube(1);
			myGL.glPopMatrix();

			// co
			myGL.glPushMatrix();
			myGL.glTranslated(0, 5 + 1.5 / 2, 0);
			myGL.glScaled(1.7, 1.5, 1.7);
			myUT.glutWireCube(1);
			myGL.glPopMatrix();

			// dau

			myGL.glPushMatrix();
			myGL.glTranslated(0, 5 + 1.5 / 2 + 2, 0);
			myUT.glutSolidSphere(2, 30, 30);
			myGL.glPopMatrix();

			// Tay phai
			myGL.glPushMatrix();
			myGL.glTranslated(4, 4, 0);
			myUT.glutWireSphere(1.1, 10, 10);
			myGL.glRotated(-90, 0, 0, 1);
			// cach tay..con chuot
				myGL.glPushMatrix();

				myGL.glRotated(armRightCornerX, 1, 0, 0);
				myGL.glRotated(armRightCornerY, 0, 1, 0);
				myGL.glRotated(armRightCornerZ, 0, 0, 1);
				myGL.glTranslated(2.8, 0, 0);
				myGL.glScaled(4, 1.3, 1.3);
				myUT.glutWireCube(1);

					// Khuyu tay
					myGL.glPushMatrix();

					myGL.glScaled(0.25, 1 / 1.3, 1 / 1.3);// reset scaled
					myGL.glTranslated(2, 0, 0);
					myUT.glutWireSphere(0.9, 10, 10);
					
					myGL.glRotated(elbowRightCornerX, 1, 0, 0);
					myGL.glRotated(elbowRightCornerZ, 0, 0, 1);
					myGL.glTranslated(2, 0, 0);
					myGL.glScaled(4, 1.1, 1.1);
					myUT.glutWireCube(1);
					// myUT.glutSolidCube(1);
					// myUT.glutSwapBuffers();
						// BAN TAY
						myGL.glColor3f(0, 1, 1);
						myGL.glPushMatrix();
						myGL.glScaled(0.25, 1 / 1.1, 1 / 1.1);// reset scaled
						myGL.glRotated(handRightCornerX, 1, 0, 0);
						myGL.glTranslated(2, 0, 0);

						myUT.glutSolidSphere(1, 10, 10);

						// co 3 ngon tay
						myGL.glColor3f(1, 1, 1);
							myGL.glPushMatrix();
							// myGL.glTranslated(2, 2, 2);
							myGL.glRotated(90, 0, 1, 0);
							myGL.glTranslated(0, -0.4, 0);
							myGL.glRotated(fingerRightCorner, 0, 1, 0);
							myUT.glutSolidCone(0.24, 2, 10, 10);
							myGL.glPopMatrix();

							myGL.glPushMatrix();
							myGL.glRotated(90, 0, 1, 0);
							myGL.glTranslated(-0.35, 0.35, 0);
							myGL.glRotated(fingerRightCorner, 0, 1, 0);
							myUT.glutSolidCone(0.24, 2, 10, 10);
							myGL.glPopMatrix();

							myGL.glPushMatrix();
							myGL.glRotated(90, 0, 1, 0);
							myGL.glTranslated(0.35, 0.35, 0);
							myGL.glRotated(fingerRightCorner, 0, 1, 0);
							myUT.glutSolidCone(0.24, 2, 10, 10);
							myGL.glPopMatrix();

						myGL.glPopMatrix();
					myGL.glPopMatrix();myGL.glPopMatrix();
					myGL.glPopMatrix();

		// Tay trai
		myGL.glPushMatrix();
		myGL.glTranslated(-4, 4, 0);
		myUT.glutWireSphere(1.1, 10, 10);
		myGL.glRotated(-90, 0, 0, 1);
		// cach tay..con chuot
		myGL.glPushMatrix();

		myGL.glRotated(armRightCornerX, 1, 0, 0);
		myGL.glRotated(armRightCornerY, 0, 1, 0);
		myGL.glRotated(armRightCornerZ, 0, 0, 1);
		myGL.glTranslated(2.8, 0, 0);
		myGL.glScaled(4, 1.3, 1.3);
		myUT.glutWireCube(1);

		// Khuyu tay
		myGL.glPushMatrix();

		myGL.glScaled(0.25, 1 / 1.3, 1 / 1.3);// reset scaled
		myGL.glTranslated(2, 0, 0);
		myUT.glutWireSphere(0.9, 10, 10);

		myGL.glRotated(elbowRightCornerX, 1, 0, 0);
		myGL.glRotated(elbowRightCornerZ, 0, 0, 1);
		myGL.glTranslated(2, 0, 0);
		myGL.glScaled(4, 1.1, 1.1);
		myUT.glutWireCube(1);
		// myUT.glutSolidCube(1);
		// myUT.glutSwapBuffers();
		// BAN TAY
		myGL.glColor3f(0, 1, 1);
		myGL.glPushMatrix();
		myGL.glScaled(0.25, 1 / 1.1, 1 / 1.1);// reset scaled
		myGL.glRotated(handRightCornerX, 1, 0, 0);
		myGL.glTranslated(2, 0, 0);

		myUT.glutSolidSphere(1, 10, 10);

		// co 3 ngon tay
		myGL.glColor3f(1, 1, 1);
		myGL.glPushMatrix();
		// myGL.glTranslated(2, 2, 2);
		myGL.glRotated(90, 0, 1, 0);
		myGL.glTranslated(0, -0.4, 0);
		myGL.glRotated(fingerRightCorner, 0, 1, 0);
		myUT.glutSolidCone(0.24, 2, 10, 10);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glRotated(90, 0, 1, 0);
		myGL.glTranslated(-0.35, 0.35, 0);
		myGL.glRotated(fingerRightCorner, 0, 1, 0);
		myUT.glutSolidCone(0.24, 2, 10, 10);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glRotated(90, 0, 1, 0);
		myGL.glTranslated(0.35, 0.35, 0);
		myGL.glRotated(fingerRightCorner, 0, 1, 0);
		myUT.glutSolidCone(0.24, 2, 10, 10);
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		myGL.glPopMatrix();

		myGL.glPopMatrix();
		myGL.glPopMatrix();
		
		// chan phai
			myGL.glPushMatrix();
			
			myGL.glTranslated(1.5, -7.5, 0);
			myGL.glRotated(bapde, 1, 0, 0);
			myGL.glScaled(2.5, 5, 2);
			myUT.glutWireCube(1);
			myGL.glScaled(0.4, 0.2, 0.5);
				myGL.glPushMatrix();
				
				myGL.glTranslated(0, -5, 0);
				myGL.glRotated(bapde, 1, 0, 0);
				myGL.glScaled(2.5, 5, 2);
				myUT.glutWireCube(1);
				myGL.glPopMatrix();
			myGL.glPopMatrix();
			
			// chan trai
						myGL.glPushMatrix();
						
						myGL.glTranslated(-1.5, -7.5, 0);
						myGL.glRotated(bapde, 1, 0, 0);
						myGL.glScaled(2.5, 5, 2);
						myUT.glutWireCube(1);
						myGL.glScaled(0.4, 0.2, 0.5);
							myGL.glPushMatrix();
							
							myGL.glTranslated(0, -5, 0);
							myGL.glRotated(bapde, 1, 0, 0);
							myGL.glScaled(2.5, 5, 2);
							myUT.glutWireCube(1);
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
			handRightCornerX += 20;
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
		EX3 mainCanvas = new EX3();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
