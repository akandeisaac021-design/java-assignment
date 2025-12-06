import java.util.Scanner;

public class NokiaInterface {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String appMenu = """
                NOKIA CONNECTING PEOPLE AND THINGS - Isaac's Hardwork

                Press 1 For Phone book
                Press 2 For Messages
                Press 3 For Chat
                Press 4 For Call Register
                Press 5 For Tones
                Press 6 For Settings
                Press 7 For Call divert
                Press 8 For Games
                Press 9 For Calculator
                Press 10 For Remainders
                Press 11 For Clock
                Press 12 For Profile
                Press 13 For SIM services
                """;

        System.out.print(appMenu);

        int menuFunction = input.nextInt();

        switch (menuFunction) {
            case 1 -> {
                System.out.println("Phonebook");
                String phoneBook = """
                        PHONEBOOK
                        Press 1 For Search
                        Press 2 For Service Number
                        Press 3 For Add name
                        Press 4 For Erase
                        Press 5 For Edit
                        Press 6 For Assign tone
                        Press 7 For Send b'card
                        Press 8 For Options
                        Press 9 For Speed dials
                        Press 10 For Voice tags
                        """;
                System.out.print(phoneBook);

                int phonebookChoice = input.nextInt();
                switch (phonebookChoice) {
                    case 1 -> System.out.print("Search");
                    case 2 -> System.out.print("Service number");
                    case 3 -> System.out.print("Add name");
                    case 4 -> System.out.print("Erase");
                    case 5 -> System.out.print("Edit");
                    case 6 -> System.out.print("Assign tone");
                    case 7 -> System.out.print("Send b'card");
                    case 8 -> {
                        System.out.print("Options");
                        String options = """
                                Press 1 For Type of view
                                Press 2 For Memory Status
                                """;
                        System.out.print(options);
                        int optionsChoice = input.nextInt();
                        switch (optionsChoice) {
                            case 1 -> System.out.print("Type of view");
                            case 2 -> System.out.print("Memory status");
                        }
                    }
                    case 9 -> System.out.print("Speed dials");
                    case 10 -> System.out.print("Voice tags");
                }
            }

            case 2 -> {
                System.out.println("Messages");
                String messages = """
                        MESSAGES
                        Press 1 For Write messages
                        Press 2 For Inbox
                        Press 3 For Outbox
                        Press 4 For Picture messages
                        Press 5 For Templates
                        Press 6 For Smileys
                        Press 7 For Send b'card
                        Press 8 For Info service
                        Press 9 For Voice mailbox number
                        Press 10 For Service command editor
                        """;
                System.out.print(messages);

                int menuMessagesChoice = input.nextInt();
                switch (menuMessagesChoice) {
                    case 1 -> System.out.print("Write messages");
                    case 2 -> System.out.print("Inbox");
                    case 3 -> System.out.print("Outbox");
                    case 4 -> System.out.print("Picture messages");
                    case 5 -> System.out.print("Templates");
                    case 6 -> System.out.print("Smileys");
                    case 7 -> System.out.print("Send b'card");
                    case 8 -> System.out.print("Info Services");
                    case 9 -> System.out.print("Voice mailbox");
                    case 10 -> System.out.print("Service Command editor");
                }
            }

            case 3 -> System.out.println("Chat");
            case 4 -> System.out.println("Call Register");
            case 5 -> System.out.println("Tones");
            case 6 -> System.out.println("Settings");
            case 7 -> System.out.println("Call divert");
            case 8 -> System.out.println("Games");
            case 9 -> System.out.println("Calculator");
            case 10 -> System.out.println("Remainders");
            case 11 -> System.out.println("Clock");
            case 12 -> System.out.println("Profile");
            case 13 -> System.out.println("SIM services");

            default -> System.out.println("Invalid choice!");
        }

        input.close();
    }
}






































































case 2 -> System.out.print("Inbox");
                    case 3 -> System.out.print("Outbox");
                    
