import java.awt.Color;
import java.awt.image.BufferedImage;//used to store images as objects
import java.io.File;
import java.net.URL;
import java.util.Arrays;//Used to have special method for arrays
import java.util.Random;
import javax.imageio.ImageIO;
public class ImageProcessing {
	public static void main(String[] args) {
    // The provided images are apple.jpg, flower.jpg, and kitten.jpg
		int[][] imageData = imgToTwoD("./apple.jpg");
 
    // Or load your own image using a URL!
		//int[][] imageData = imgToTwoD("https://seriable.com/wp-content/uploads/2019/08/duff-mckagan-cover.jpg");

    //Creating a negative image.
    //int [][] negImage = negativeColor(imageData);
    //twoDToImage(negImage, "./negative_Duff.jpg");

    //Creating a streched image.
    int [][] stredImage = stretchHorizontally(imageData);
    twoDToImage(stredImage, "./stretched_Apple.jpg");

    //Creating a shrinked image
    int [][] shrinkedImage = shrinkVertically(imageData);
    twoDToImage(shrinkedImage, "./shrinked_Apple.jpg");

    //Creating an inverted image
    int [][] invertedIm = invertImage(imageData);
    twoDToImage(invertedIm, "./inverted_Apple.jpg");

    //Creating image with filter
    int [][] imagFil = colorFilter(imageData,-75,30,-30);
    twoDToImage(imagFil, "./filtered_Apple.jpg");

    /*Creating a randomly edited image
    int [][] ranIm =  paintRandomImage(imageData);
    twoDToImage(ranIm, "./ran_Apple.jpg");
   */
      int[][] blankImg = new int[500][500];
              
      int[][] randomImg = paintRandomImage(blankImg);
              
      twoDToImage(randomImg, "./random_img.jpg");

      //Paint rectangle
int[] rgba = {255, 255, 0, 255};
        
int[][] rectangleImg = paintRectangle(randomImg, 200, 200, 100, 100, getColorIntValFromRGBA(rgba));
        
twoDToImage(rectangleImg, "./rectangle.jpg");

//Paint rectangles
int[][] recsImg = generateRectangles(imageData,100);
        
twoDToImage(recsImg, "./rectangless.jpg");

		//viewImageData(imageData); //Extracts a 3x3 section from the top left of the image. viw the image data in raw pixel form and RGA extracted.
		//int[][] trimmed = trimBorders(imageData, 60);
		//twoDToImage(trimmed, "./trimmed_apple.jpg");
		// int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
		// Painting with pixels
	}
	// Image Processing Methods
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
        
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}
	public static int[][] negativeColor(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    int[][] negImage = new int[imageTwoD.length][imageTwoD[0].length]; 

        for(int i=0; i<imageTwoD.length; i++)//Row-major
        {
            for(int j=0; j<imageTwoD[0].length; j++)
            {
              int[] rgba= getRGBAFromPixel(imageTwoD[i][j]);//gets every RGBA value from an specific pixel in the image.  
              rgba[0] = 255 - rgba[0];
              rgba[1] = 255 - rgba[1];
              rgba[2] = 255 - rgba[2];
              negImage[i][j] = getColorIntValFromRGBA(rgba);
              

            }

        }
     
     
    return negImage;
		//return null;
	}
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
    int[][] stretchedImage = new int[imageTwoD.length][imageTwoD[0].length*2];

    int it= 0; //Variable to keep track
    for(int i = 0; i<imageTwoD.length; i++)//Row major
    {
        for(int j=0; j<imageTwoD[0].length; j++)
        {
        //  int PixTwoTimes =imageTwoD[i][j];
        it = j*2;
          stretchedImage[i][it] = imageTwoD[i][j];
          stretchedImage[i][it+1] = imageTwoD[i][j];
        }
    }
 
		// TODO: Fill in the code for this method
		return stretchedImage;
	}
	public static int[][] shrinkVertically(int[][] imageTwoD) {
    int[][] shrinkedImage = new int[imageTwoD.length/2][imageTwoD[0].length];

            for(int i=0; i<imageTwoD[0].length; i++)
            {
              for(int j=0; j<imageTwoD.length-1; j+=2)
              {
                  shrinkedImage[j/2][i] =imageTwoD[j][i];
              }

            }

		// TODO: Fill in the code for this method
		return shrinkedImage;
	}
	public static int[][] invertImage(int[][] imageTwoD) {
    int[][] invertedImage = new int[imageTwoD.length][imageTwoD[0].length];

      for(int i=0; i<imageTwoD.length; i++)
      { 
          for(int j=0; j<imageTwoD[0].length; j++)
          {

            invertedImage[i][j] = imageTwoD[(imageTwoD.length-1)-i][(imageTwoD[0].length-1)-j];
          }
      }

		// TODO: Fill in the code for this method
		return invertedImage;
	}
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
    int[][] imageWFilter = new int[imageTwoD.length][imageTwoD[0].length];

    for(int i=0; i<imageTwoD.length; i++)
    {
        for(int j=0; j<imageTwoD[0].length; j++)
        {
            int[] pix = getRGBAFromPixel(imageTwoD[i][j]);
            pix[0] += redChangeValue;
            pix[1] += greenChangeValue;
            pix[2] += blueChangeValue;

                for(int p=0; p<pix.length; p++)
                {
                  if(pix[p]<0)
                  {
                    pix[p]=0;
                  }
                  else if(pix[p]>255)
                  {
                    pix[p]=255;
                  }
                }
            imageWFilter[i][j] = getColorIntValFromRGBA(pix);
        }
    }
    
		// TODO: Fill in the code for this method

		return imageWFilter;
	}
	// Painting Methods
	public static int[][] paintRandomImage(int[][] canvas) {
    Random rand = new Random();
    for(int i=0; i<canvas.length; i++)
    {
        for(int j=0; j<canvas[0].length; j++)
        {
          int num1=rand.nextInt(256);
          int num2=rand.nextInt(256);
          int num3=rand.nextInt(256); 

          int[] array = {num1,num2,num3,255};
          canvas[i][j] =getColorIntValFromRGBA(array);
          
        }
    }
		// TODO: Fill in the code for this method
		return canvas;
	}
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
		// TODO: Fill in the code for this method
   for(int i=0; i<canvas.length; i++)
   {
      for(int j=0; j<canvas[0].length; j++)
      {
          if(i>=rowPosition &&i<=rowPosition+width&& j>=colPosition &&j<=colPosition+height )
          {
              canvas[i][j] = color;
          } 
      }
   }

		return canvas;
	}
	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
  Random obj = new Random();
  Random rand = new Random();
  for(int i=0; i<numRectangles; i++)
  {
    int rectWidth= obj.nextInt(canvas[0].length);
    int rectHeigth= obj.nextInt(canvas.length);

    int rowPosition =obj.nextInt(canvas.length-rectHeigth);
    int colPosition = obj.nextInt(canvas[0].length-rectWidth);

          int num1=rand.nextInt(256);
          int num2=rand.nextInt(256);
          int num3=rand.nextInt(256); 

          int[] array = {num1,num2,num3,255};
          int randomColor = getColorIntValFromRGBA(array); 
          canvas=paintRectangle(canvas, rectWidth, rectHeigth, rowPosition, colPosition, randomColor);

         
    


  
  }


		// TODO: Fill in the code for this method
		return canvas;
	}
	// Utility Methods
	public static int[][] imgToTwoD(String inputFileOrLink) { //Method that converts URL or file image to a 2D array.
		try {
			BufferedImage image = null;
           if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) //Checks whether the string is a link or a file
              { 
                URL imageUrl = new URL(inputFileOrLink); //if it is a link it uses the URL library 
                image = ImageIO.read(imageUrl);   //now "image" declared in "BufferedImage" has stored the image of the url
                  if (image == null) //if image is still null mayb the url doesn't exist
                  { 
                    System.out.println("Failed to get image from provided URL.");
                  }
               }
             else  //if none of the above are cached then the string was referencing a file
                  {
                    image = ImageIO.read(new File(inputFileOrLink)); //image is a file
                  }
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols]; //Creates the 2D matrix 
			for (int i = 0; i < imgRows; i++) { //Row-majo traversal
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i); //now the image provided is a 2d matrix
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
	public static void twoDToImage(int[][] imgData, String fileName) {// converts 2D array to image and saves it as whatever the "filename" value is. 
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}
	public static int[] getRGBAFromPixel(int pixelColorValue) { //int pixelColorValue converts hexadecimal pixel value to a 1D matrix of 4 elements (R,G,B,A)
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}
	public static int getColorIntValFromRGBA(int[] colorData) {  //it gets a matrix containing RGBA int values of a pixel and converts it to Hex
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}