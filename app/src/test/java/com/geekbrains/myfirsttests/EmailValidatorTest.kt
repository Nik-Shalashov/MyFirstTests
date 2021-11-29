package com.geekbrains.myfirsttests

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    @Test
    fun `проверка на наличие домена`() {
        assertFalse(EmailValidator.isValidEmail("name@.com"))
    }

    @Test
    fun `проверка на валидные символы в имени`() {
        assertFalse(EmailValidator.isValidEmail("&<>$#@mail.com"))
    }

    @Test
    fun `проверка на валидные символы в домене`() {
        assertFalse(EmailValidator.isValidEmail("name@&$<>?.com"))
    }

    @Test
    fun `проверка на не нулл`(){
        assertNotNull(EmailValidator.isValidEmail("name@mail.com"))
    }

    @Test
    fun `проверка на нулл`(){
        assertNull(EmailValidator.isValidEmail(null))
    }

    @Test
    fun `проверка на совпадение`() {
        assertEquals(EmailValidator.isEqualsEmail(), "example@mail.com")
    }

    @Test
    fun `проверка на несовпадение`() {
        assertNotEquals(EmailValidator.isEqualsEmail(), "another@mail.com")
    }

    @Test
    fun `проверка на совпадение массивов`() {
        assertArrayEquals(EmailValidator.isArrayEmailsEquals(), arrayOf("num1@mail.com", "num2@mail.com", "num3@mail.com"))
    }

    @Test
    fun `тест на одинаковый возвращаемый объект`(){
        assertSame(EmailValidator.isSameTest1(), EmailValidator.isSameTest2())
    }
}
