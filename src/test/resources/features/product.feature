Feature: product data table practice

  @ListOfMap @smoke
  Scenario: verify each product price
    #practice List<Map<String,String>>
    Given User is on the HomePage
    Then  User should be able to see expected prices in the following products
      | Category | Product           | expectedPrice |
      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |

     #List Element 1 (Map):
     #{Category=Phone,Product=Samsung galaxy s6,ExpectedPrice=360}
     #List Element 2 (Map):
     #{Category=Phone,Product=Nokia lumia 1520,ExpectedPrice=820}
     #List Element 3 (Map):
     #{Category=Phone,Product=Nexus 6 ,ExpectedPrice=650}
     #List Element 4 (Map):
     #{Category=Phone,Product=Sony vaio i5,ExpectedPrice=790}
     #List Element 5 (Map):
     #{Category=Phone,Product=Sony vaio i7,ExpectedPrice=790}
     #List Element 6 (Map):
     #{Category=Phone,Product=MacBook air ,ExpectedPrice=700}
     #List Element 7 (Map):
     #{Category=Phone,Product=Apple monitor 24,ExpectedPrice=400}
     #List Element 8 (Map):
     #{Category=Phone,Product=ASUS Full HD,ExpectedPrice=230}


  @listOfList @smoke
  #practice List<list<String>>
  Scenario: Verify each product price ListOfList
    Given User is on the HomePage
    Then User should be able to see expected prices in the following products with listOfLists

      | Phones   | Samsung galaxy s6 | 360           |
      | Phones   | Nokia lumia 1520  | 820           |
      | Phones   | Nexus 6           | 650           |
      | Laptops  | Sony vaio i5      | 790           |
      | Laptops  | Sony vaio i7      | 790           |
      | Laptops  | MacBook air       | 700           |
      | Monitors | Apple monitor 24  | 400           |
      | Monitors | ASUS Full HD      | 230           |
    #List ELement 1(List<String>): [Phones ,Samsung galaxy s6,360]
    #List ELement 2(List<String>): [Phones ,Nokia lumia 1520, 820]
    #List ELement 3(List<String>): [Phones ,Nexus 6 ,650]
    #List ELement 4(List<String>): [Laptops ,Sony vaio i5 s6,790]
    #List ELement 5(List<String>): [Laptops ,Sony vaio i7,790]
    #List ELement 6(List<String>): [Laptops ,MacBook air,700]
    #List ELement 7(List<String>): [Monitors ,Apple monitor 24,400]
   #List ELement 8(List<String>): [Monitors ,Apple monitor 24,400]

  @mapList @smoke
  #practice Map<String,List<String>>
  Scenario: Verify students names on discord
    Then user should be able to see the following names in their groups

    |Group 1 | Nadir | Feyruz | Shakir |
    |Group 2 | Yulia | Roma | Nazarii  |


