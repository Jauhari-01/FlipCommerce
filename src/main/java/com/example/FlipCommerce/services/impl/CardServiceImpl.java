package com.example.FlipCommerce.services.impl;

import com.example.FlipCommerce.dto.requestDto.CardRequestDto;
import com.example.FlipCommerce.dto.responseDto.CardResponseDto;
import com.example.FlipCommerce.exceptions.CustomerNotFoundException;
import com.example.FlipCommerce.models.Card;
import com.example.FlipCommerce.models.Customer;
import com.example.FlipCommerce.repository.CardRepository;
import com.example.FlipCommerce.repository.CustomerRepository;
import com.example.FlipCommerce.services.CardService;
import com.example.FlipCommerce.transformers.CardTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CardRepository cardRepository;

    @Override
    public CardResponseDto addCard(CardRequestDto cardRequestDto) throws CustomerNotFoundException {
        Customer customer = customerRepository.findByEmailId(cardRequestDto.getCustomerEmailId());
        if (customer == null){
            throw new CustomerNotFoundException("Invalid customer emailId.");
        }

        /*Dto --> Card(Entity)*/
        Card card = CardTransformer.cardRequestDtoToCard(cardRequestDto);
        card.setCustomer(customer);
        customer.getCards().add(card); // Update the card list

        /*saved into database*/
        Customer savedCustomer = customerRepository.save(customer);  // Saved both customer and card

        /*Card(Entity) --> Dto*/
        return CardTransformer.cardToCardResponseDto(card);
    }

    @Override
    public String cardTypeMaxNumberOfTimes() {
        Iterable<Card> cardIterable = cardRepository.findAll();

        /*Call to cardIterableTable method*/
        HashMap<String, Integer> hm = cardIterableTable(cardIterable);

        String cardType = "";
        int max = Integer.MIN_VALUE;
        for (String key : hm.keySet()) {
            if (hm.get(key) > max){
                max = hm.get(key);
                cardType = key;
            }
        }
        return cardType;
    }

    @Override
    public String cardTypeMinNumberOfTimes() {
        Iterable<Card> cardIterable = cardRepository.findAll();

        /*Call to cardIterableTable method*/
        HashMap<String, Integer> hm = cardIterableTable(cardIterable);

        String cardType = "";
        int min = Integer.MAX_VALUE;
        for (String key : hm.keySet()) {
            if (hm.get(key) < min){
                min = hm.get(key);
                cardType = key;
            }
        }
        return cardType;
    }

    //Utility Functions
    private HashMap<String, Integer> cardIterableTable(Iterable<Card> cardIterable) {
        HashMap<String, Integer> hm = new HashMap<>();

        /*Iterate whole card table*/
        for (Card card: cardIterable) {
            String cardType = card.getCardType().toString();
            hm.put(cardType, hm.getOrDefault(cardType, 0) + 1);
        }
        return  hm;
    }
}
