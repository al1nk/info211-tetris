import java.util.*;


/**
 * An immutable representation of a tetris piece in a particular rotation. Each
 * piece is defined by the blocks that make up its body.
 * 
 * Typical client code looks like...
 * 
 * <pre>
 * Piece pyra = new Piece(PYRAMID_STR); // Create piece from string
 * int width = pyra.getWidth(); // 3
 * Piece pyra2 = pyramid.computeNextRotation(); // get rotation
 * 
 * Piece[] pieces = Piece.getPieces(); // the array of all root pieces
 * </pre>
 */
public class Piece {

	// String constants for the standard 7 Tetris pieces
	public static final String STICK_STR = "0 0 0 1 0 2 0 3";
	public static final String L1_STR = "0 0 0 1 0 2 1 0";
	public static final String L2_STR = "0 0 1 0 1 1 1 2";
	public static final String S1_STR = "0 0 1 0 1 1 2 1";
	public static final String S2_STR = "0 1 1 1 1 0 2 0";
	public static final String SQUARE_STR = "0 0 0 1 1 0 1 1";
	public static final String PYRAMID_STR = "0 0 1 0 1 1 2 0";

	// Attributes
	private List<TPoint> body;
	private List<Integer> skirt;
	private int width;
	private int height;
	
	static private Piece[] pieces; // singleton static array of first rotations

	/**
	 * Defines a new piece given a TPoint[] array of its body. Makes its own
	 * copy of the array and the TPoints inside it.
	 */
	public Piece(List<TPoint> points) {
		this.body=points;
		
	    this.width=0;
	    for (int i=0; i<this.body.size(); i++) {
	        if(this.body.get(i).x > this.width) {
	        	this.width = this.body.get(i).x;
	        }
	    }
	    this.width++;
	    
	    List<Integer> temp = new ArrayList<Integer>();
	    this.skirt = new ArrayList<Integer>();
	    for (int i=0; i<this.body.size(); i++) {
	    	if(temp.contains(this.body.get(i).x)==false) {
	    		this.skirt.add(this.body.get(i).x, this.body.get(i).y);
	    		temp.add(this.body.get(i).x);
	    	}
	    }
	    
	    this.height=0;
		for (int i=0; i<this.body.size(); i++) {
		    if(this.body.get(i).y > this.height) {
		    	this.height=this.body.get(i).y;
		    }
		}
		this.height++;
	}
	
	/**
	 * Alternate constructor, takes a String with the x,y body points all
	 * separated by spaces, such as "0 0 1 0 2 0 1 1". (provided)
	 */
	public Piece(String points) {
		this.body=parsePoints(points);
		
		this.width=0;
	    for (int i=0; i<this.body.size(); i++) {
	        if(this.body.get(i).x > this.width) {
	        	this.width = this.body.get(i).x;
	        }
	    }
	    this.width++;
	    
	    List<Integer> temp = new ArrayList<Integer>();
	    this.skirt = new ArrayList<Integer>();
	    for (int i=0; i<this.body.size(); i++) {
	    	if(temp.contains(this.body.get(i).x)==false) {
	    		this.skirt.add(this.body.get(i).x, this.body.get(i).y);
	    		temp.add(this.body.get(i).x);
	    	}
	    }
	    
	    this.height=0;
		for (int i=0; i<this.body.size(); i++) {
		    if(this.body.get(i).y > this.height) {
		    	this.height=this.body.get(i).y;
		    }
		}
		this.height++;
	}

	public Piece(Piece piece) {
		this.body=piece.getBody();
		
		this.width=0;
	    for (int i=0; i<this.body.size(); i++) {
	        if(this.body.get(i).x > this.width) {
	        	this.width = this.body.get(i).x;
	        }
	    }
	    this.width++;
	    
	    List<Integer> temp = new ArrayList<Integer>();
	    this.skirt = new ArrayList<Integer>();
	    for (int i=0; i<this.body.size(); i++) {
	    	if(temp.contains(this.body.get(i).x)==false) {
	    		this.skirt.add(this.body.get(i).x, this.body.get(i).y);
	    		temp.add(this.body.get(i).x);
	    	}
	    }
	    
	    this.height=0;
		for (int i=0; i<this.body.size(); i++) {
		    if(this.body.get(i).y > this.height) {
		    	this.height=this.body.get(i).y;
		    }
		}
		this.height++;
	}


	/**
	 * Given a string of x,y pairs ("0 0 0 1 0 2 1 0"), parses the points into a
	 * TPoint[] array. (Provided code)
	 */
	private static List<TPoint> parsePoints(String rep) {
		List<TPoint> points = new ArrayList<TPoint>();
		StringTokenizer token = new StringTokenizer(rep);
		while(token.hasMoreTokens()) {
			int x = Integer.parseInt(token.nextToken());
			int y = Integer.parseInt(token.nextToken());
				
			points.add(new TPoint(x, y));
		}
		return points;
	}
	
	/**
	 * Returns the width of the piece measured in blocks.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Returns the height of the piece measured in blocks.
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Returns a reference to the piece's body. The caller should not modify this
	 * list.
	 */
	public List<TPoint> getBody() {
		return this.body;
	}

	/**
	 * Returns a reference to the piece's skirt. For each x value across the
	 * piece, the skirt gives the lowest y value in the body. This is useful for
	 * computing where the piece will land. The caller should not modify this
	 * list.
	 */
	public List<Integer> getSkirt() {
		return this.skirt;
	}

	/**
	 * Returns a new piece that is 90 degrees counter-clockwise rotated from the
	 * receiver.
	 */
	public Piece computeNextRotation() {
		List<TPoint> newPoints = new ArrayList<TPoint>();
		TPoint temp;
		for (int i=0; i<this.body.size(); i++) {
			temp= new TPoint(Math.abs(this.body.get(i).y - (this.height-1)), this.body.get(i).x);
			newPoints.add(temp);
		}
	    return new Piece(newPoints);
	}

	/**
	 * Returns true if two pieces are the same -- their bodies contain the same
	 * points. Interestingly, this is not the same as having exactly the same
	 * body arrays, since the points may not be in the same order in the bodies.
	 * Used internally to detect if two rotations are effectively the same.
	 */
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String stringSkirt = "";
		for(int i=0; i<this.skirt.size(); i++) {
			 stringSkirt += Integer.toString(this.skirt.get(i)) + " ";
		}
		
		String stringBody = "";
		for(int i=0; i<this.body.size(); i++) {
			 stringBody += Integer.toString(this.body.get(i).x) + " ";
			 stringBody += Integer.toString(this.body.get(i).y) + " ";
		}
		
		String image = "Shape {\n";
	    image += "width=" + this.width + "; height=" + this.height + "; skirt=" + stringSkirt + "\n";
	    image += "body=" + stringBody + "\n";
	    char[][] grille = new char[this.height][this.width];
	   
	    for(int i=0; i<this.height; i++) {
	    	Arrays.fill(grille[i], ' ');
	    }
	    
	    for(int i=0; i<this.body.size(); i++) {
	    	grille[Math.abs(this.body.get(i).y - this.height + 1)][this.body.get(i).x] = 'X';
	    }
	    
	    String s = "";
	    for(int i=0; i<this.height; i++) {
	    	s += new String(grille[i]) + "\n";
	    }
	    
	    image += s;
	    return image;
	}

	/**
	 * Returns an array containing the first rotation of each of the 7 standard
	 * tetris pieces in the order STICK, L1, L2, S1, S2, SQUARE, PYRAMID. The
	 * next (counterclockwise) rotation can be obtained from each piece with the
	 * {@link #fastRotation()} message. In this way, the client can iterate
	 * through all the rotations until eventually getting back to the first
	 * rotation. (provided code)
	 */
	public static Piece[] getPieces() {
		// lazy evaluation -- create static array if needed
		if (Piece.pieces == null) {
			Piece.pieces = new Piece[] { 
					new Piece(STICK_STR), 
					new Piece(L1_STR),
					new Piece(L2_STR), 
					new Piece(S1_STR),
					new Piece(S2_STR),
					new Piece(SQUARE_STR),
					new Piece(PYRAMID_STR)};
		}

		return Piece.pieces;
	}

}
