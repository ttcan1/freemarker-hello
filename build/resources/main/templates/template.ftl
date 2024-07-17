<#-- This is the template for generating a C++ class -->
#ifndef ${className?upper_case}_H
#define ${className?upper_case}_H

class ${className} {
public:
    ${className}();
    ~${className}();

<#list fields as field>
    ${field.type} get${field.name?cap_first}() const;
    void set${field.name?cap_first}(${field.type} ${field.name});
</#list>
    
private:
<#list fields as field>
    ${field.type} ${field.name};
</#list>
};

#endif // ${className?upper_case}_H
