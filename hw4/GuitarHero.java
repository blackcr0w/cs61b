// A client that uses the synthesizer package to replicate a plucked guitar string sound
public class GuitarHero {
      public static void main(String[] args) {

          // create two guitar strings, for concert A and C
          double CONCERT_A = 440.0;

          double CONCERTS[] = new double[37];

          for (int i = 0; i < 37; i += 1) {
            CONCERTS[i] = CONCERT_A * Math.pow(2, (i - 24.0) / 12.0);
          }

          String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
          synthesizer.GuitarString strings[];
          strings = new synthesizer.GuitarString[37]; ////Q1 
          for (int i = 0; i < 37; i += 1) {
            strings[i] = new synthesizer.GuitarString(CONCERTS[i]);
          }


          while (true) {

              // check if the user has typed a key; if so, process it   
              if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  int n = keyboard.indexOf(key);
                  if (n == -1) continue;
                  strings[n].pluck();
              }

              // compute the superposition of samples
              double sample = 0;
              for (int i = 0; i < 37; i += 1) {
                sample = strings[i].sample() + sample;
              }
  
              // play the sample on standard audio
              // note: this is just playing the double value YOUR GuitarString
              //       class is generating. 
              StdAudio.play(sample);
  
              // advance the simulation of each guitar string by one step   
              for (int i = 0; i < 37; i += 1) {
                strings[i].tic();
              }
          }
       }
  }
