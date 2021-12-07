package lap3.Excersive;

import java.awt.Frame;
import java.io.IOException;

import jgl.GL;
import jgl.GLCanvas;

public class EX1a extends GLCanvas {

	double R = 10;
	int rateX = 10, rateY = 20;
	int ox = 0, oy = 0;
	double denta = 2 * Math.PI / rateY;
	double beta = 2 * Math.PI / rateX;
	double g = 5, d=0;

	public void display() {
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT);
		myGL.glColor3f(0f, 0.0f, 0f);
		// Ve mat phang
		myGL.glPushMatrix();
		myGL.glBegin(GL.GL_POLYGON);
		myGL.glVertex3d(-10, 0, 4);
		myGL.glVertex3d(-10, 0, -4);
		myGL.glVertex3d(10, 0, -4);
		myGL.glVertex3d(10, 0, 4);
		myGL.glEnd();
			myGL.glPushMatrix();
				myGL.glColor3f(0f, 1.0f, 0f);	
				myGL.glTranslated(-8-d, 2, 0);	
				myGL.glRotated(g, 0, 0, 1);
			//myGL.glTranslated(-8+d, 2, 0);
				myUT.glutWireSphere(2, 15, 15);
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
		case 'q':
			g= g+5;
			d = 2*Math.PI * 2* g/360;
			myUT.glutPostRedisplay();
			break;
		case 'w':
			g-=5;
			d = 2*Math.PI * 2* g/360;
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
		EX1a mainCanvas = new EX1a();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}
