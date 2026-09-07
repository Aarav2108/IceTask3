package com.mycompany.icetask3;
import java.util.Scanner;

public class IceTask3 {

        public static final int[] ITEM_NUMBERS = {111, 222, 333, 444};
    public static final double[] PRICES    = {0.89, 1.47, 2.43, 5.99};
 
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        boolean validOrder = false;
 
        while (!validOrder)
        {
            try
            {
                System.out.print("Enter item number (0-9999): ");
                String itemInput = input.nextLine();
                int itemNumber = validateItemNumber(itemInput);
 
                System.out.print("Enter quantity (1-12): ");
                String quantityInput = input.nextLine();
                int quantity = validateQuantity(quantityInput);
 
                double price = findPrice(itemNumber);
                double total = price * quantity;
 
                System.out.printf("%nTotal amount due: $%.2f%n", total);
                validOrder = true;
            }
            catch (OrderException e)
            {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again.\n");
            }
        }
 
        input.close();
    }
 
    public static int validateItemNumber(String itemInput) throws OrderException
    {
        int itemNumber;
        try
        {
            itemNumber = Integer.parseInt(itemInput.trim());
        }
        catch (NumberFormatException e)
        {
            throw new OrderException(OrderMessages.MESSAGES[OrderMessages.ITEM_NOT_NUMERIC]);
        }
 
        if (itemNumber < 0)
        {
            throw new OrderException(OrderMessages.MESSAGES[OrderMessages.ITEM_TOO_LOW]);
        }
        if (itemNumber > 9999)
        {
            throw new OrderException(OrderMessages.MESSAGES[OrderMessages.ITEM_TOO_HIGH]);
        }
 
        return itemNumber;
    }
 
    public static int validateQuantity(String quantityInput) throws OrderException
    {
        int quantity;
        try
        {
            quantity = Integer.parseInt(quantityInput.trim());
        }
        catch (NumberFormatException e)
        {
            throw new OrderException(OrderMessages.MESSAGES[OrderMessages.QUANTITY_NOT_NUMERIC]);
        }
 
        if (quantity < 1)
        {
            throw new OrderException(OrderMessages.MESSAGES[OrderMessages.QUANTITY_TOO_LOW]);
        }
        if (quantity > 12)
        {
            throw new OrderException(OrderMessages.MESSAGES[OrderMessages.QUANTITY_TOO_HIGH]);
        }
 
        return quantity;
    }
 
    public static double findPrice(int itemNumber) throws OrderException
    {
        for (int i = 0; i < ITEM_NUMBERS.length; i++)
        {
            if (ITEM_NUMBERS[i] == itemNumber)
            {
                return PRICES[i];
            }
        }
        throw new OrderException(OrderMessages.MESSAGES[OrderMessages.ITEM_NOT_FOUND]);
    }
    }

