package com.dagabienkowska.documentmanager.components;

import com.dagabienkowska.documentmanager.models.Document;
import com.dagabienkowska.documentmanager.services.DocumentService;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class DocumentValidator implements Validator {

    private final DocumentService documentService;

    public DocumentValidator(DocumentService documentService) {
        this.documentService = documentService;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Document.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Document document = (Document) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fileName", "NotEmpty");

        if (documentService.findByFileName(document.getFileName()) != null){
            errors.rejectValue("fileName", "Duplicated.documentForm.fileName");
        }

        if (document.getFileName().length() < 3 || document.getFileName().length() > 30){
            errors.rejectValue("fileName", "Size.documentForm.fileName");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "NotEmpty");

        if (document.getDescription().length() < 2){
            errors.rejectValue("description", "Size.documentForm.description");
        }
    }
}
