import logo from './img/logo.jpg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo}/>
      </header>
      <form>
      <div class="col-lg-12 login-title">
                <p class="center">Countries:</p>
                <select name="countries_plates" id="countries_list"
                        onchange="document.getElementById('countries_image').src = countryImage[this.value];"
                        class="form__input center">
                    <option value="None">Choose country</option>
                    <option value="AM">🇦🇲&emsp;Armenia</option>
                    <option value="AU">🇦🇹&emsp;Austria</option>
                    <option value="AZ">🇦🇿&emsp;Azerbaijan</option>
                    <option value="BY">🇧🇾&emsp;Belarus</option>
                    <option value="GB">🇻🇬&emsp;Great Britain</option>
                    <option value="BG">🇧🇬&emsp;Bulgaria</option>
                    <option value="HR">🇭🇷&emsp;Croatia</option>
                    <option value="CZ">🇨🇿&emsp;Czech Republic</option>
                    <option value="EE">🇪🇪&emsp;Estonia</option>
                    <option value="FR">🇫🇷&emsp;France</option>
                    <option value="DE">🇩🇪&emsp;Germany</option>
                    <option value="GR">🇬🇷&emsp;Greece</option>
                    <option value="HU">🇭🇺&emsp;Hungary</option>
                    <option value="IE">🇮🇪&emsp;Ireland</option>
                    <option value="IT">🇮🇹&emsp;Italy</option>
                    <option value="KZ">🇰🇿&emsp;Kazakhstan</option>
                    <option value="KO">🇽🇰&emsp;Kosovo</option>
                    <option value="KG">🇰🇬&emsp;Kyrgyzstan</option>
                    <option value="LT">🇱🇹&emsp;Lithuania</option>
                    <option value="MD">🇲🇩&emsp;Moldova</option>
                    <option value="ME">🇲🇪&emsp;Montenegro</option>
                    <option value="NO">🇳🇴&emsp;Norway</option>
                    <option value="PL">🇵🇱&emsp;Poland</option>
                    <option value="RO">🇷🇴&emsp;Romania</option>
                    <option value="RU">🇷🇺&emsp;Russia</option>
                    <option value="SK">🇸🇰&emsp;Slovakia</option>
                    <option value="SI">🇸🇮&emsp;Slovenia</option>
                    <option value="SE">🇸🇪&emsp;Sweden</option>
                    <option value="CH">🇨🇭&emsp;Switzerland</option>
                    <option value="TR">🇹🇷&emsp;Turkey</option>
                    <option value="UA">🇺🇦&emsp;Ukraine</option>
                    <option value="UZ">🇺🇿&emsp;Uzbekistan</option>
                </select>
            </div>
            <p class="center">Diplomatic:</p>
            <select name="diplomatic_plates" id="countries_diplomatic_list"
                    onchange="document.getElementById('countries_image').src = diplomaticImage[this.value];"
                    class="form__input center">
                <option value="None">Choose country</option>
                <option value="AU">🇦🇹&emsp;Austria</option>
                <option value="DE">🇩🇪&emsp;Germany</option>
                <option value="PL">🇵🇱&emsp;Poland</option>
                <option value="HR">🇭🇷&emsp;Croatia</option>
                <option value="EE">🇪🇪&emsp;Estonia</option>
                <option value="FR">🇫🇷&emsp;France</option>
                <option value="IT">🇮🇹&emsp;Italy</option>
                <option value="KG">🇰🇬&emsp;Kyrgyzstan</option>
                <option value="LT">🇱🇹&emsp;Lithuania</option>
                <option value="ME">🇲🇪&emsp;Montenegro</option>
                <option value="NO">🇳🇴&emsp;Norway</option>
                <option value="RO">🇷🇴&emsp;Romania</option>
                <option value="SE">🇸🇪&emsp;Sweden</option>
                <option value="CH">🇨🇭&emsp;Switzerland</option>
            </select>
            <div>
          <label htmlFor="region">Region</label>
          <input type="text" id="region" />

          <label htmlFor="description">Description</label>
          <input type="text" id="description" />
        </div>

      </form>
    </div>
  );
}

export default App;
