#ifndef PERSON_H
#define PERSON_H

class Person {
public:
    Person();
    ~Person();

    std::string getName() const;
    void setName(std::string name);
    int getAge() const;
    void setAge(int age);
    
private:
    std::string name;
    int age;
};

#endif // PERSON_H
