package ru.nsu.laptev;

import java.util.ArrayList;

import java.util.Collections;

import java.util.Map;

/**
 * Класс для создания нашего диллера
 */
public class Dealer extends Player
{
    /**
     *
     * @param exmp
     */
    public void ShuffleDeck(Deck exmp)
    {
        Collections.shuffle(exmp.deck);
    }

    /**
     *
     * @param exmp1
     * @param hand
     */
    public void DealCards(Deck exmp1, ArrayList<ArrayList<String>> hand)
    {
        int cardIndex = exmp1.deck.size() - 1;
        hand.add(exmp1.deck.get(cardIndex));
        exmp1.deck.remove(cardIndex);
    }

    /**
     *
     * @param amount_of_cards
     * @param values
     * @param is_first_round
     */
    public void WriteCards(int amount_of_cards, Map<String, Integer> values,boolean is_first_round)
    {
        System.out.print("Карты дилера: [");
        if (is_first_round) {
            int value = values.get(hand.get(0).get(0));
            System.out.println(hand.get(0).get(0) + " " + hand.get(0).get(1) + " (" + value + "), <закрытая карта>]\n");
        }
        else {
            score = 0;
            for (int i = 0; i < amount_of_cards; i++)
            {
                int value = values.get(hand.get(i).get(0));
                if (hand.get(i).get(0) == "Туз" && bust > 0) {
                    value = 1;
                }
                score += value;
                System.out.print(hand.get(i).get(0) +" "+ hand.get(i).get(1) + " (" + value + ")");
                if (i+1 != amount_of_cards)
                    System.out.print(", ");
            }
            System.out.println("] -> " + score + "\n");
        }
    }

    /**
     *
     * @param deck
     * @param values
     * @param player
     */
    public void DealersTurn(Deck deck, Map<String, Integer> values, Player player)
        {
            System.out.println("Ход дилера\n-------\nДилер открывает закрытую карту " + hand.get(1).get(0) + " " + hand.get(1).get(1) + " (" + values.get(hand.get(1).get(0)) + ")");
            player.WriteCards(player.hand.size(),values);
            WriteCards(hand.size(), values, false);
            while (score < 17){
                ArrayList<String> card = deck.TakeCard();
                hand.add(card);
                int value = values.get(card.get(0));
                score += value;
                if (score > 21){
                    for (int i = 0;i < hand.size(); i++)
                    {
                        if (hand.get(i).get(0) == "Туз")
                        {
                            bust = 1;
                            break;
                        }
                    }
                }
                System.out.println("Дилер открывает карту " + card.get(0) + " " + card.get(1) + " (" + value + ")");
                player.WriteCards(player.hand.size(),values);
                WriteCards(hand.size(), values, false);
            }
        }
//    @Override
}
