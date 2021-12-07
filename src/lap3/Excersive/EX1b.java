package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX1b extends GLCanvas {

	double R = 10;
	double g = 5, d;// d la doan dich chuyen theo truc 0x
	double dentaD = d - R;// tu tam den hinh tron theo truc ox
	double cosDenta_R = dentaD / R;
	double accos = Math.acos(cosDenta_R);
	double h = R * Math.sin(accos);

	// Math.sqrt(R*R -Math.abs(R-d))
	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);

		// Ve mat phangq
		myGL.glPushMatrix();
		myGL.glColor3f(0f, 0.0f, 1f);
		myGL.glTranslated(-10 + d, -2, 0);
		myGL.glRotated(5, 1, 1, 0);
		myGL.glScaled(2, 1, 1);
		myUT.glutWireCube(4);
		myGL.glPopMatrix();

		myGL.glPushMatrix();
		myGL.glColor3f(0f, 1.0f, 0f);
		myGL.glTranslated(-10 + d, 2 + h, 0);
		myGL.glRotated(g, 0, 0, 1);
		myUT.glutWireSphere(2, 15, 15);
		myGL.glPopMatrix();

		myGL.glFlush();
	}

	public void keyboard(char key, int x, int y) {
		boolean quay = false;
		switch (key) {
		case 'e':
			if (d < 20) {
				g += 5;
				d = 2 * Math.PI * g / 180;
				dentaD = d - R;// tu tam den hinh tron theo truc ox
				cosDenta_R = dentaD / R;
				accos = Math.acos(cosDenta_R);
				if (cosDenta_R > 1) {
					h = 0;
				} else {
					h = R * Math.sin(accos);
				}

				myUT.glutPostRedisplay();
			}
			break;
		case 'q':
			if (d > 0) {
				g -= 5;
				d = 2 * Math.PI * 2 * g / 360;

				dentaD = d - R;// tu tam den hinh tron theo truc ox
				cosDenta_R = dentaD / R;
				accos = Math.acos(cosDenta_R);
				if (cosDenta_R < -1) {
					h = 0;
				} else {
					h = R * Math.sin(accos);

				}

				myUT.glutPostRedisplay();
			}
			break;
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
		myGL.glClearColor(0, 0, 0, 0.0f);
		myGL.glViewport(0, 10, w, h); /* define the viewport */ // muon quay thi phai co ham nay
		myGL.glMatrixMode(GL.GL_PROJECTION); /* prepare for and then */
		myGL.glLoadIdentity();/* define the projection */
//		myGLU.gluPerspective(180, 1f, 0.1f, 40);
//		myGL.glMatrixMode(GL.GL_MODELVIEW); /* prepare for and then */
//		myGL.glLoadIdentity();
//		myGLU.gluLookAt( 0.0, 0.0, 7.0, 
//				 0.0, 0.0, 0.0, 
//				 0.0, 1.0, 0.0 );

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
		EX1b mainCanvas = new EX1b();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
