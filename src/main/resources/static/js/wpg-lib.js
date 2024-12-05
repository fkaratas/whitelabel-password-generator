function PasswordParameters(pwLength, includeSymbols, includeNumbers, includeLowercase, includeUppercase, includeMinus, includeUnderscore, includeWhitespace, includeBrackets, additionalCharacters) {
    this.pwLength = pwLength;
    this.includeSymbols = includeSymbols;
    this.includeNumbers = includeNumbers;
    this.includeLowercase = includeLowercase;
    this.includeUppercase = includeUppercase;
    this.includeMinus = includeMinus;
    this.includeUnderscore = includeUnderscore;
    this.includeWhitespace = includeWhitespace;
    this.includeBrackets = includeBrackets;
    this.additionalCharacters = additionalCharacters;
}

function generatePassword(passwordParams) {         
    const passSrc = buildPassSourceString(passwordParams);
    
    if (passSrc.length === 0) {
        return;
    }
    let password = "";
    for (let i = 0; i < passwordParams.pwLength; i++) {
        const rand = nextCryptoRand();
        password += passSrc[rand % passSrc.length];
    }
    return password;
}

function buildPassSourceString(passwordParams) {
    const lowercase = "abcdefghijklmnopqrstuvxwyz";
    const uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const numbers = "0123456789";
    const symbols = "!\"#$%&'*+,./:;=?@\\^|~";
    const minus = "-";
    const underscore = "_";
    const whitespace = " ";
    const brackets = "[]{}()<>";
    
    let passSrc = "";
    
    if (passwordParams.includeSymbols) {
        passSrc += symbols;
    }
    if (passwordParams.includeNumbers) {
        passSrc += numbers;
    }
    if (passwordParams.includeUppercase) {
        passSrc += uppercase;
    }
    if (passwordParams.includeLowercase) {
        passSrc += lowercase;
    }
    if (passwordParams.includeMinus) {
        passSrc += minus;
    }
    if (passwordParams.includeUnderscore) {
        passSrc += underscore;
    }
    if (passwordParams.includeWhitespace) {
        passSrc += whitespace;
    }
    if (passwordParams.includeBrackets) {
        passSrc += brackets;
    }
    if (passwordParams.additionalCharacters.length > 0) {
        passSrc += passwordParams.additionalCharacters;
    }
    
    return passSrc;
}

function nextCryptoRand() {
    const rand = new Uint32Array(1);
    window.crypto.getRandomValues(rand);        
    return rand[0];
}

function getParameterById(id) {
    const idString = '#' + id;
    if ($(idString).is(':checkbox')) {
        return $(idString).is(':checked');
    } else {
        return $(idString).val();
    }
}
