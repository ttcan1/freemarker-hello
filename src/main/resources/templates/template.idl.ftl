<#-- This is the template for generating an IDL file for CycloneDDS-CXX -->
module ${moduleName} {

    struct ${structName} {
    <#list fields as field>
        ${field.type} ${field.name};
    </#list>
    };
    
    // Add more IDL definitions as needed
};
