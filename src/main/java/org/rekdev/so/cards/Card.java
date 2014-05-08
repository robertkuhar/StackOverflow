package org.rekdev.so.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Simple Card class
 * 
 * @see <a href="http://goo.gl/vuA1Bq">stackoverflow: Is there a way to sort a
 *      string array in a specific non-alphabetical order?</a>
 * 
 */
public class Card {
    public static enum Rank {
        One( 1 ),
        Two( 2 ),
        Three( 3 ),
        Four( 4 ),
        Five( 5 ),
        Six( 6 ),
        Seven( 7 ),
        Eight( 8 ),
        Nine( 9 ),
        Ten( 10 ),
        Jack( 11 ),
        Queen( 12 ),
        King( 13 ),
        Ace( 14 );

        public final int value;

        private Rank( int value ) {
            this.value = value;
        }
    }

    public static enum Suit {
        Spade, Heart, Diamond, Club
    }

    public final Rank rank;
    public final Suit suit;

    public Card( Rank rank, Suit suit ) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder( this.getClass().getSimpleName() );
        sb.append( "( rank: " + rank );
        sb.append( ", suit: " + suit );
        sb.append( ")" );
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( rank == null ) ? 0 : rank.hashCode() );
        result = prime * result + ( ( suit == null ) ? 0 : suit.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj ) {
            return true;
        }
        if ( obj == null ) {
            return false;
        }
        if ( getClass() != obj.getClass() ) {
            return false;
        }
        Card other = (Card) obj;
        if ( rank != other.rank ) {
            return false;
        }
        if ( suit != other.suit ) {
            return false;
        }
        return true;
    }

    public static void main( String[] args ) {
        Card aceOfSpades = new Card( Rank.Ace, Suit.Spade );
        System.out.println( "aceOfSpades: " + aceOfSpades );
        System.out.println( "aceOfSpades.rank.ordinal: " + aceOfSpades.rank.ordinal() );
        System.out.println( "aceOfSpades.rank.value: " + aceOfSpades.rank.value );

        List<Card> deck = new ArrayList<Card>();
        for ( Suit suit : Suit.values() ) {
            for ( Rank rank : Rank.values() ) {
                deck.add( new Card( rank, suit ) );
            }
        }

        System.out.println( "deck: " + deck );

        Collections.sort( deck, new Comparator<Card>() {
            public int compare( Card c1, Card c2 ) {
                int result = c1.rank.value - c2.rank.value;
                return result;
            }
        } );

        System.out.println( "deck: " + deck );
    }

}
