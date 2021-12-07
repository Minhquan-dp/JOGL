package finalexample;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.String;
import java.lang.System;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import jgl.GL;
import jgl.GLCanvas;
import jgl.GLU;
import jgl.glu.GLUquadricObj;

public class RobotFinal extends GLCanvas {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double gocnhin = 0;
	int t=0, r=0, shoulder =0, elbow=0;
	int x1=0;
	double y1;
	double y2;
	double g=5;
	
	float quaytrai, quayphai;
	float zoom = -5;

	private static final int checkImgWidth = 256;
	private static final int checkImgHeight = 256;
	private byte imgCenter[][][] = new byte[checkImgWidth][checkImgHeight][4];
	private byte imgLeft[][][] = new byte[checkImgWidth][checkImgHeight][4];
	private byte imgRight[][][] = new byte[checkImgWidth][checkImgHeight][4];
	private byte imgBottom[][][] = new byte[checkImgWidth][checkImgHeight][4];
	private byte imgTop[][][] = new byte[checkImgWidth][checkImgHeight][4];
	
	private int texName[] = new int[5];
	private void imgMake () {
		int i,j;
		String str = "D:\\sự nghiệp\\đồ h�?a\\Tutors\\Tutors\\Images\\";
		
		File bmpCenterFile = new File(str+"Swimming Pool Surround - Part 4.bmp");
		File bmpRightFile = new File(str+"Swimming Pool Surround - Part 6.bmp");
		File bmpLeftFile = new File(str+"Swimming Pool Surround - Part 6.bmp"); 
		File bmpTopFile = new File(str+"Sky.bmp"); 
		File bmpBottomFile = new File(str+"Swimming Pool Background.bmp");

		try {
			BufferedImage iCenter = ImageIO.read(bmpCenterFile);
			BufferedImage iRight = ImageIO.read(bmpRightFile);
			BufferedImage iLeft = ImageIO.read(bmpLeftFile);
			BufferedImage iTop = ImageIO.read(bmpTopFile);
			BufferedImage iBottom = ImageIO.read(bmpBottomFile);
			
			for (i = 0; i < checkImgWidth; i++) {
				for (j = 0; j < checkImgHeight; j++) {	
					
					Color cCenter = new Color(iCenter.getRGB(i, j)); 					
					Color cRight = new Color(iRight.getRGB(i, j)); 
					Color cLeft = new Color(iLeft.getRGB(i, j)); 
					Color cTop = new Color(iTop.getRGB(i,j ));
					Color cBottom = new Color(iBottom.getRGB(i, j));
					
					imgCenter[j][i][0] = (byte)(cCenter.getRed() ); 
					imgCenter[j][i][1] = (byte) (cCenter.getGreen());
					imgCenter[j][i][2]  = (byte) (cCenter.getBlue());
					imgCenter[i][j][3] = (byte) 255;
					
					imgRight[j][i][0] = (byte) (cRight.getRed()); 
					imgRight[j][i][1] = (byte) (cRight.getGreen());
					imgRight[j][i][2] = (byte) (cRight.getBlue()); 
					imgRight[i][j][3] = (byte) 255;
					
					imgLeft[j][i][0] = (byte) (cLeft.getRed()); 
					imgLeft[j][i][1] = (byte) (cLeft.getGreen()); 
					imgLeft[j][i][2]= (byte) (cLeft.getBlue());
					imgLeft[i][j][3] = (byte) 255;
					
					imgTop[j][i][0] = (byte) (cTop.getRed()); 
					imgTop[j][i][1] = (byte)(cTop.getGreen());
					imgTop[j][i][2] =(byte)(cTop.getBlue()); 
					imgTop[i][j][3]= (byte) 255;
					
					imgBottom[j][i][0] = (byte) (cBottom.getRed());
					imgBottom[j][i][1] = (byte)(cBottom.getGreen()); 
					imgBottom[j][i][2] = (byte) (cBottom.getBlue()); 
					imgBottom[i][j][3] = (byte) 255;

				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private int startList;

    public void errorCallback (int errorCode) {
	String estring;

	estring = GLU.gluErrorString (errorCode);
	System.err.println ("Quadric Error: "+estring);
    }
	
		GLUquadricObj qobj;
		float mat_ambient[] = { 0.5f, 0.5f, 0.5f, 1.0f };
		float mat_specular[] = { 1.0f, 1.0f, 1.0f, 1.0f };
		float mat_shininess[] = { 50.0f };
		float light_position[] = { 1.0f, 1.0f, 1.0f, 0.0f };
		float lmodel_ambient [] = {1.5f,1.5f,1.5f,1.0f};
		private void myinit() {
			
		myGL.glClearColor (0.0f, 0.0f, 0.0f, 0.0f);

		myGL.glMaterialfv (GL.GL_FRONT, GL.GL_AMBIENT, mat_ambient);
		myGL.glMaterialfv (GL.GL_FRONT, GL.GL_SPECULAR, mat_specular);
		myGL.glMaterialfv (GL.GL_FRONT, GL.GL_SHININESS, mat_shininess);
		myGL.glLightfv (GL.GL_LIGHT0, GL.GL_POSITION, light_position);
		myGL.glLightModelfv (GL.GL_LIGHT_MODEL_AMBIENT, lmodel_ambient);

		myGL.glEnable (GL.GL_LIGHTING);
		myGL.glEnable (GL.GL_LIGHT0);
		myGL.glEnable (GL.GL_DEPTH_TEST);
		
		//create blocks
		
				startList = myGL.glGenLists (17);
				qobj = myGLU.gluNewQuadric();
				myGLU.gluQuadricCallback (qobj, GLU.GLU_ERROR, "errorCallback");
				
				//than
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList, GL.GL_COMPILE);
			    myGLU.gluCylinder (qobj, 0.8, 0.8, 2, 114, 1);
				myGL.glEndList();
				//co
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+1, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.3, 0.2, 0.2, 114, 1);
				myGL.glEndList();		
				//dau
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+2, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.55, 15, 10);
				myGL.glEndList();
				//dui trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+3, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.32, 0.34, 1, 114, 1);
				myGL.glEndList();
				//dui phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+4, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.32, 0.34, 1, 114, 1);
				myGL.glEndList();	
				//dau goi trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+5, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.28, 15, 10);
				myGL.glEndList();
				//dau goi phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+6, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.28, 15, 10);	
				myGL.glEndList();
				//chan trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+7, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.25, 0.28, 1, 114, 1);
				myGL.glEndList();
				//chan phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+8, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.25, 0.28, 1, 114, 1);
				myGL.glEndList();
				//mat ca trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+9, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.24, 15, 10);
				myGL.glEndList();
				//mat ca phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+10, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.24, 15, 10);	
				myGL.glEndList();
				//khop tay trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+11, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.28, 15, 10);
				myGL.glEndList();
				//khop tay phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+12, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.28, 15, 10);	
				myGL.glEndList();
				
				//bap tay phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+13, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.29, 0.2, 2, 114, 1);
				myGL.glEndList();
				//bap tay trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* flat shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_FLAT);
				myGL.glNewList (startList+14, GL.GL_COMPILE);
				myGLU.gluCylinder (qobj, 0.29, 0.2, 2, 114, 1);
				myGL.glEndList();	
				//khuy tay phai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+15, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.28, 15, 10);
				myGL.glEndList();
				//khuy tay trai
				myGLU.gluQuadricDrawStyle (qobj, GLU.GLU_FILL); /* smooth shaded */
				myGLU.gluQuadricNormals (qobj, GLU.GLU_SMOOTH);
				myGL.glNewList (startList+16, GL.GL_COMPILE);
				myGLU.gluSphere (qobj, 0.28, 15, 10);	
				myGL.glEndList();
		
				
//		myGL.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//		myGL.glShadeModel(GL.GL_SMOOTH);
//		myGL.glEnable(GL.GL_DEPTH_TEST);

		imgMake(); 
		myGL.glPixelStorei (GL.GL_UNPACK_ALIGNMENT, 1);
		
		myGL.glGenTextures (5, texName);
		myGL.glBindTexture (GL.GL_TEXTURE_2D, texName [0]);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D (GL.GL_TEXTURE_2D,0, GL.GL_RGBA, checkImgWidth,
		checkImgHeight, 0, GL. GL_RGBA, GL. GL_UNSIGNED_BYTE, imgCenter);
		
		myGL.glBindTexture (GL.GL_TEXTURE_2D, texName [1]);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D (GL.GL_TEXTURE_2D,0, GL.GL_RGBA, checkImgWidth,
		checkImgHeight, 0, GL. GL_RGBA, GL. GL_UNSIGNED_BYTE, imgRight);
		
		myGL.glBindTexture (GL.GL_TEXTURE_2D, texName [2]);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL.GL_CLAMP);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL.GL_CLAMP);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf (GL.GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D (GL.GL_TEXTURE_2D,0, GL.GL_RGBA, checkImgWidth,
				checkImgHeight, 0, GL. GL_RGBA, GL. GL_UNSIGNED_BYTE, imgLeft);
		
		myGL.glBindTexture (GL.GL_TEXTURE_2D, texName [3]);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL. GL_CLAMP);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL. GL_CLAMP);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D (GL.GL_TEXTURE_2D,0, GL.GL_RGBA, checkImgWidth,
				checkImgHeight, 0, GL. GL_RGBA, GL. GL_UNSIGNED_BYTE, imgTop);
		
		myGL.glBindTexture (GL.GL_TEXTURE_2D, texName [4]);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_S, GL. GL_CLAMP);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_WRAP_T, GL. GL_CLAMP);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_MAG_FILTER, GL.GL_NEAREST);
		myGL.glTexParameterf (GL. GL_TEXTURE_2D, GL.GL_TEXTURE_MIN_FILTER, GL.GL_NEAREST);
		myGL.glTexImage2D (GL.GL_TEXTURE_2D,0, GL.GL_RGBA, checkImgWidth,
				checkImgHeight, 0, GL. GL_RGBA, GL. GL_UNSIGNED_BYTE, imgBottom);
		
		myGL.glEnable(GL.GL_TEXTURE_2D);
		
	}
	float height = 1;
	public void initboat() {
		float ctrlpoints[][][] = {
				{ { 0, 2, height }, { 0, 2, -2f }, { 0, 2, -2f }, { 0, 2, height } },
				{ { -1.5f, 0, height }, { 0, -1, -2 }, { 0, -1, -2 }, { 1.5f, 0, height } },
				{ { -1.5f, 0, height }, { 0, -1, -2 }, { 0, -1, -2f }, { 1.5f, 0, height } },
				{ { 0, -2, height }, { 0, -2, -2.0f }, { 0, -2, -2.0f }, { 0, -2, height } } };

		float texpts[][][] = { { { 0.0f, 0.0f }, { 0.0f, 1.0f } },
				{ { 1.0f, 0.0f }, { 1.0f, 1.0f } } };
		myGL.glMap2f(GL.GL_MAP2_VERTEX_3, 0.0f, 1.0f, 3, 4, 0.0f, 1.0f, 12, 4, ctrlpoints);
		myGL.glMap2f(GL.GL_MAP2_TEXTURE_COORD_2, 0.0f, 1.0f, 2, 2, 0.0f, 1.0f, 4, 2, texpts);
		myGL.glEnable(GL.GL_MAP2_TEXTURE_COORD_2);
		myGL.glEnable(GL.GL_MAP2_VERTEX_3);
		myGL.glMapGrid2f(20, 0.0f, 1.0f, 20, 0.0f, 1.0f);
		
		myGL.glPushMatrix();
		myGL.glPointSize(5.0f);
		myGL.glBegin(GL.GL_POINTS);

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				myGL.glColor3f(1.0f, 0.0f, 0.0f);
				myGL.glVertex3f(ctrlpoints[i][j][0], ctrlpoints[i][j][1], ctrlpoints[i][j][2]);
			}
		}

		myGL.glEnd();
		myGL.glPopMatrix();
	}
	public void boat() {
		myGL.glPushMatrix();
		myGL.glTranslated(-2+y1, 1.25, 0.5);
		myGL.glRotated(90, 0, 0, 1.0);
//		myGL.glRotated(y1, 0, 1, 0);
		myGL.glScaled(0, 0.5, 0.5);
		
		initboat();
		myGL.glEvalMesh2(GL.GL_FILL, 0, 20, 0, 20);
		myGL.glPopMatrix();
	}
	
	// ve mau than
		float robot[]={0.1f,0.5f,0.8f,1.0f};
		float robot1[]={1.0f,1.0f,1.0f,1.0f};
		float robot2[]={100.0f};
		

		
	public void display() {
		
		myGL.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		myGL.glPushMatrix();
		myGL.glTranslatef(0, 0, zoom);
		myGL.glRotatef(quaytrai, 1, 0, 0);
		myGL.glRotatef(quayphai, 0, 1, 0);
		
		
		myGL.glMatrixMode(GL.GL_MODELVIEW);
		myGL.glLoadIdentity();
		myGL.glEnable(GL.GL_DEPTH_TEST);
		
	    myGL.glMaterialfv (GL.GL_FRONT, GL.GL_DIFFUSE, robot);
	    myGL.glMaterialfv (GL.GL_FRONT, GL.GL_SPECULAR, robot1);
	    myGL.glMaterialfv (GL.GL_FRONT, GL.GL_SHININESS, robot2);

		
		//room
//		myGLU.gluLookAt(0.0, 0.0, 50.0 , 0.0, 0.0, 0.0, 0.0, 2.0, 0.0); 
		myGL.glTranslatef(0.0f, 0.0f,t);
		myGL.glRotatef(r, 1.0f, 0.0f, 0.0f);
		myGL.glEnable(GL. GL_TEXTURE_2D);
		
		myGL.glBindTexture (GL. GL_TEXTURE_2D, texName [0]);
		myGL.glBegin (GL.GL_QUADS);
		myGL.glTexCoord2f (0f, 0.0f); myGL.glVertex3f (-2.0f, -2.0f, -2.0f); 
		myGL.glTexCoord2f (1f, 0.0f); myGL.glVertex3f (2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f (1f, 1.0f); myGL.glVertex3f (2f, 2.0f, -2.0f);
		myGL.glTexCoord2f (0f, 1.0f); myGL.glVertex3f (-2.0f, 2f, -2.0f);
		myGL.glEnd();
		
		myGL.glBindTexture (GL. GL_TEXTURE_2D, texName [1]);
		myGL.glBegin (GL.GL_QUADS);
		myGL.glTexCoord2f (0f, 0.0f); myGL.glVertex3f (2.0f, 2.0f, -2.0f); 
		myGL.glTexCoord2f (1f, 0.0f); myGL.glVertex3f (2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f (1f, 1.0f); myGL.glVertex3f (2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f (0f, 1.0f); myGL.glVertex3f (2.0f, 2.0f, 2.0f);
		myGL.glEnd();
		
		myGL.glBindTexture (GL. GL_TEXTURE_2D, texName [2]);
		myGL.glBegin (GL.GL_QUADS);
		myGL.glTexCoord2f (0f, 0.0f); myGL.glVertex3f (-2.0f, 2.0f, -2.0f); 
		myGL.glTexCoord2f (1f, 0.0f); myGL.glVertex3f (-2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f (1f, 1.0f); myGL.glVertex3f (-2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f (0f, 1.0f); myGL.glVertex3f (-2.0f, 2.0f, 2.0f);
		myGL.glEnd();

		myGL.glBindTexture (GL. GL_TEXTURE_2D, texName [3]);
		myGL.glBegin (GL.GL_QUADS);
		myGL.glTexCoord2f (0f, 0.0f); myGL.glVertex3f (-2.0f, 2.0f, -2.0f); 
		myGL.glTexCoord2f (1f, 0.0f); myGL.glVertex3f (2.0f, 2.0f, -2.0f);
		myGL.glTexCoord2f (1f, 1.0f); myGL.glVertex3f (2.0f, 2.0f, 2.0f);
		myGL.glTexCoord2f (0f, 1.0f); myGL.glVertex3f (-2.0f, 2.0f, 2.0f);
		myGL.glEnd();
		
		myGL.glBindTexture (GL. GL_TEXTURE_2D, texName [4]);
		myGL.glBegin (GL.GL_QUADS);
		myGL.glTexCoord2f (0f, 0.0f); myGL.glVertex3f (-2.0f, -2.0f, 2.0f); 
		myGL.glTexCoord2f (1f, 0.0f); myGL.glVertex3f (2.0f, -2.0f, 2.0f);
		myGL.glTexCoord2f (1f, 1.0f); myGL.glVertex3f (2.0f, -2.0f, -2.0f);
		myGL.glTexCoord2f (0f, 1.0f); myGL.glVertex3f (-2.0f, -2.0f, -2.0f);
		myGL.glEnd();
		
		myGL.glDisable(GL.GL_TEXTURE_2D);
		myGL.glEnable (GL.GL_LIGHTING);
		myGL.glEnable (GL.GL_LIGHT0);
		

				//robot
				myGL.glPushMatrix(); 
				myGL.glScaled(0.3,0.3,0.3);
				myGL.glTranslatef(7.5f, -3.0f, 1.0f);
				myGL.glEnable (GL.GL_LIGHTING);
					//than
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-4.0f, 0.0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList);
					myGL.glPopMatrix ();
					
					//co
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.0f, 2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+1);
					myGL.glPopMatrix ();
					
					//dau
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0f, 0.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+2);
					myGL.glPopMatrix ();
					
					//dui trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.4f, -3.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+3);
					myGL.glPopMatrix ();
				
					//dui phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+4);
					myGL.glPopMatrix ();
					
					//dau goi trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+5);
					myGL.glPopMatrix ();

					//dau goi phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+6);
					myGL.glPopMatrix ();

					//chan trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.8f, -1.2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+7);
					myGL.glPopMatrix ();
				
					//chan phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+8);
					myGL.glPopMatrix ();
					
					//mat ca trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+9);
					myGL.glPopMatrix ();

					//mat ca phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+10);
					myGL.glPopMatrix ();

					//khop tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.2f, 4.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
//						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+11);
					myGL.glPopMatrix ();
				
					//khop tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (1.6f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+12);
					myGL.glPopMatrix ();
					
					//bap tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.1f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, -50f, 0f);
						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+13);
					myGL.glPopMatrix ();
				
					//bap tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
					myGL.glRotatef (270f, -50f, 1.0f, 0.0f);
						
						myGL.glCallList (startList+14);
					myGL.glPopMatrix ();
					
					
					
					
			
					

					myGL.glEnable(GL.GL_TEXTURE_2D);
				myGL.glPopMatrix();
				
				//robot1
				myGL.glPushMatrix(); 
				myGL.glScaled(0.3,0.3,0.3);
				myGL.glTranslatef(5f, -3.0f, 4.0f);
				myGL.glEnable (GL.GL_LIGHTING);
					//than
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-4.0f, 0.0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList);
					myGL.glPopMatrix ();
					
					//co
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.0f, 2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+1);
					myGL.glPopMatrix ();
					
					//dau
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0f, 0.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+2);
					myGL.glPopMatrix ();
					
					//dui trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.4f, -3.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+3);
					myGL.glPopMatrix ();
				
					//dui phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+4);
					myGL.glPopMatrix ();
					
					//dau goi trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+5);
					myGL.glPopMatrix ();

					//dau goi phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+6);
					myGL.glPopMatrix ();

					//chan trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.8f, -1.2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+7);
					myGL.glPopMatrix ();
				
					//chan phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+8);
					myGL.glPopMatrix ();
					
					//mat ca trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+9);
					myGL.glPopMatrix ();

					//mat ca phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+10);
					myGL.glPopMatrix ();

					//khop tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.2f, 4.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
//						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+11);
					myGL.glPopMatrix ();
				
					//khop tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (1.6f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+12);
					myGL.glPopMatrix ();
					
					//bap tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.1f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, -50f, 0f);
						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+13);
					myGL.glPopMatrix ();
				
					//bap tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
					myGL.glRotatef (270f, -50f, 1.0f, 0.0f);
						
						myGL.glCallList (startList+14);
					myGL.glPopMatrix ();
					
				
					
					
			
					

					myGL.glEnable(GL.GL_TEXTURE_2D);
				myGL.glPopMatrix();
				
				//robot2
				myGL.glPushMatrix(); 
				myGL.glScaled(0.3,0.3,0.3);
				myGL.glTranslatef(0f, -3.0f, 4.0f);
				myGL.glEnable (GL.GL_LIGHTING);
					//than
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-4.0f, 0.0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList);
					myGL.glPopMatrix ();
					
					//co
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.0f, 2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+1);
					myGL.glPopMatrix ();
					
					//dau
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0f, 0.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+2);
					myGL.glPopMatrix ();
					
					//dui trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.4f, -3.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+3);
					myGL.glPopMatrix ();
				
					//dui phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+4);
					myGL.glPopMatrix ();
					
					//dau goi trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+5);
					myGL.glPopMatrix ();

					//dau goi phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+6);
					myGL.glPopMatrix ();

					//chan trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.8f, -1.2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+7);
					myGL.glPopMatrix ();
				
					//chan phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+8);
					myGL.glPopMatrix ();
					
					//mat ca trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+9);
					myGL.glPopMatrix ();

					//mat ca phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+10);
					myGL.glPopMatrix ();

					//khop tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.2f, 4.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
//						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+11);
					myGL.glPopMatrix ();
				
					//khop tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (1.6f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+12);
					myGL.glPopMatrix ();
					
					//bap tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.1f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, -50f, 0f);
						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+13);
					myGL.glPopMatrix ();
				
					//bap tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
					myGL.glRotatef (270f, -50f, 1.0f, 0.0f);
						
						myGL.glCallList (startList+14);
					myGL.glPopMatrix ();
					
					
					
		

					myGL.glEnable(GL.GL_TEXTURE_2D);
				myGL.glPopMatrix();
				
				//robot3
				myGL.glPushMatrix(); 
				myGL.glScaled(0.1,0.1,0.1);
			
				myGL.glTranslated(-13+y2, 17, 0.0);
				myGL.glEnable (GL.GL_LIGHTING);
					//than
					myGL.glColor3d(3, 0, 2);
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-4.0f, 0.0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList);
					myGL.glPopMatrix ();
					
					//co
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.0f, 2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+1);
					myGL.glPopMatrix ();
					
					//dau
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0f, 0.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+2);
					myGL.glPopMatrix ();
					
					//dui trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.4f, -3.5f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+3);
					myGL.glPopMatrix ();
				
					//dui phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+4);
					myGL.glPopMatrix ();
					
					//dau goi trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+5);
					myGL.glPopMatrix ();

					//dau goi phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+6);
					myGL.glPopMatrix ();

					//chan trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-0.8f, -1.2f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+7);
					myGL.glPopMatrix ();
				
					//chan phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+8);
					myGL.glPopMatrix ();
					
					//mat ca trai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (-0.8f, -0.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+9);
					myGL.glPopMatrix ();

					//mat ca phai
					myGL.glEnable (GL.GL_LIGHTING);
					myGL.glShadeModel (GL.GL_SMOOTH);
					myGL.glTranslatef (0.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glCallList (startList+10);
					myGL.glPopMatrix ();

					//khop tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.2f, 4.1f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
//						myGL.glRotated(x1, 1, 0, 0);
						myGL.glCallList (startList+11);
					myGL.glPopMatrix ();
				
					//khop tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (1.6f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, 1.0f, 0f, 0.0f);
						myGL.glCallList (startList+12);
					myGL.glPopMatrix ();
					
					//bap tay trai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (0.1f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, -50f, 1.0f, 0f);
						myGL.glCallList (startList+13);
					myGL.glPopMatrix ();
				
					//bap tay phai
					myGL.glShadeModel (GL.GL_FLAT);
					myGL.glTranslatef (-1.8f, 0f, 0.0f);
					myGL.glPushMatrix ();
						myGL.glRotatef (270f, -50f, 1.0f, 0.0f);
						
						myGL.glCallList (startList+14);
					myGL.glPopMatrix ();
					
					

					myGL.glEnable(GL.GL_TEXTURE_2D);
				myGL.glPopMatrix();
				
				boat();
				myGL.glPopMatrix();
				
				myGL.glFlush();
	}
	
	public void myReshape(int w, int h) {
		myGL.glViewport(0, 0, w, h);
		myGL.glMatrixMode(GL.GL_PROJECTION);
		myGL.glLoadIdentity();
		myGLU.gluPerspective(60.0, (double) w / (double) h, 1.0, 20.0);
		myGL.glTranslatef(0.0f, 0.0f, -5.0f);
		myGL.glMatrixMode(GL.GL_MODELVIEW);
		myGL.glLoadIdentity();
	}

	public void keyboard(char key, int x, int y) {
		switch (key) {
		
		case 'c':
			if (x1 < 90)
				x1 += 2;

			myUT.glutPostRedisplay();
			break;
		case 'v':
			if (x1 > -90)
				x1 -= 2;
			myUT.glutPostRedisplay();
			break;
		case 'b':
			if (y1 > -90)
				y1 += 5;
			myUT.glutPostRedisplay();
			break;
		case 'e':
			if (y1 < 20) {
				g += 2;
				y1 = 0.5 * Math.PI * g / 180;
				
				myUT.glutPostRedisplay();
			}
			break;
		case 'w':
			if (y2 < 50) {
				g += 5;
				y2 = 5 * Math.PI * g / 180;
				
				myUT.glutPostRedisplay();
			}
			break;
		case 27:
			System.exit(0);
		default:
			break;
		}
	}

	public void init() {
		myUT.glutInitWindowSize(900, 900);
		myUT.glutInitWindowPosition(0, 0);
		myUT.glutCreateWindow(this);
		myinit();
		myUT.glutDisplayFunc("display");
		myUT.glutReshapeFunc("myReshape");
		myUT.glutKeyboardFunc("keyboard");
		myUT.glutMainLoop();
	}
	static public void main(String args[]) throws IOException {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(800, 800);
		RobotFinal mainCanvas = new RobotFinal();
		mainCanvas.init();
		mainFrame.add(mainCanvas);
		mainFrame.setVisible(true);
	}

}