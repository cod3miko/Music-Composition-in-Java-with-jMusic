import jm.JMC; //jMusic constants for pitch and rhythmic values
import jm.music.data.*; //Holds files used to hold the jMusic data representation aka MIDI
import jm.util.*; //Contains classes that translate and modify jMusic data.

public class ode2Joy implements JMC
{
 public static void main(String[] args)
 {
   
  // set up the pitches and durations line by line
   
  int[] pitchMelody =     {E4,E4,F4,G4,G4,F4,E4,D4,C4,C4,D4,E4,E4,D4,D4,
                           E4,E4,F4,G4,G4,F4,E4,D4,C4,C4,D4,E4,D4,C4,C4,
                           D4,D4,E4,C4,D4,E4,F4,E4,C4,D4,E4,F4,E4,D4,C4,D4,G3,
                           E4,E4,E4,F4,G4,G4,F4,E4,D4,C4,C4,D4,E4,D4,C4,C4};
  double[] rhythmMelody = {C,C,C,C,C,C,C,C,C,C,C,C,DC,Q,HN,
                           C,C,C,C,C,C,C,C,C,C,C,C,DC,Q,HN,
                           C,C,C,C,C,EN,EN,C,C,C,EN,EN,C,C,C,C,C,
                           C,C,C,C,C,C,C,C,C,C,C,C,C,DC,Q,HN};
  
  int[] pitchHarmony =     {C3,G3,E3,G3,
                            C3,G3,E3,F3,E3,
                            G3,G3,G3,GS3,A3,G3,
                            G3,G3,G3,F3,E3};
  double[] rhythmHarmony = {WN,WN,WN,WN,
                            WN,WN,WN,HN,HN,
                            WN,WN,HN,HN,HN,HN,
                            WN,WN,WN,HN,HN};
  
  int[] pitchBass =     {G3,G3,G3,D3,C3,G3,
                         G3,G3,F3,E3,D3,G3,G3,
                         B2,C3,B2,C3,B2,E3,REST,
                         G3,F3,E3,D3,C3,G3};
  double[] rhythmBass = {WN,WN,HN,C,C,WN,
                         WN,C,C,C,C,WN,WN,
                         HN,HN,HN,HN,WN,HN,HN,
                         HN,HN,HN,HN,WN,WN};

  
  //create the jMusic phrase objects
  Phrase Melody = new Phrase();
  Phrase Harmony = new Phrase();
  Phrase Bass = new Phrase();
  
  // add the notes to each phrase
  Melody.addNoteList(pitchMelody, rhythmMelody);
  Harmony.addNoteList(pitchHarmony, rhythmHarmony);
  Bass.addNoteList(pitchBass, rhythmBass);
  
  // create jMusic parts
  Part m = new Part("Melody", STRINGS);
  Part h = new Part("Harmony", STRINGS);
  Part b = new Part("Bass", STRINGS);
  
  // add the phrases to the parts
  m.addPhrase(Melody);
  h.addPhrase(Harmony);
  b.addPhrase(Bass);
  
  //create a score
  Score score = new Score("Ode To Joy");
  
  //add the parts to the score
  score.addPart(m);
  score.addPart(h);
  score.addPart(b);

  // tempo
  score.setTempo(130.0);
  
  //display the result
  View.show(score);
  
  // save score as a MIDI file
  Write.midi(score, "Ode To Joy.mid");
 }
}