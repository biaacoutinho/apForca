public class ControladorDeLetrasJaDigitadas implements Cloneable
{
    private String letrasJaDigitadas;

    public ControladorDeLetrasJaDigitadas ()
    {
        // torna this.letrasJaDigitadas igual ao String vazio

        this.letrasJaDigitadas = "";
    }

    public boolean isJaDigitada (char letra)
    {
        // percorrer o String this.letrasJaDigitadas e verificar se ele
        // possui a letra fornecida, retornando true em caso afirmativo
        // ou false em caso negativo

        for (int i = 0; i < this.letrasJaDigitadas.length(); i += 1)
        {
            if (this.letrasJaDigitadas.charAt(i) == letra)
                return true;
        }

        return false;
    }

    public void registre (char letra) throws Exception
    {
		// verifica se a letra fornecida ja foi digitada (pode usar
		// o m�todo this.isJaDigitada, para isso), lancando uma exce��o
		// em caso afirmativo.
		// concatena a letra fornecida a this.letrasJaDigitadas.

        if (isJaDigitada(letra))
            throw new Exception("Letra já digitada!");
        
        this.letrasJaDigitadas += letra;
    }

    public String toString ()
    {
		// retorna um String com TODAS as letras presentes em
		// this.letrasJaDigitadas separadas por v�rgula (,).

        String letrasSeparadasPorVirgula = "";

        for (int i = 0; i < this.letrasJaDigitadas.length(); i += 1)
        {
            letrasSeparadasPorVirgula += this.letrasJaDigitadas.charAt(i);

            if (i != this.letrasJaDigitadas.length() - 1)
                letrasSeparadasPorVirgula += ',';
        }

        return letrasSeparadasPorVirgula;
    }

    public boolean equals (Object obj)
    {
        // verificar se this e obj s�o iguais

        if (this == obj)
            return true;
        
        if (obj == null)
            return false;

        if (obj.getClass() != ControladorDeLetrasJaDigitadas.class)
            return false;

        ControladorDeLetrasJaDigitadas ret = (ControladorDeLetrasJaDigitadas) obj;

        if (this.letrasJaDigitadas.equals(ret.letrasJaDigitadas))
            return false;

        return true;
    }

    public int hashCode ()
    {
        // calcular e retornar o hashcode de this

        int ret = 456;

        ret = 23 * ret + new String (this.letrasJaDigitadas).hashCode();
        
        if (ret < 0)
            ret = -ret;

        return ret;
    }

    // construtor de c�pia
    
    public ControladorDeLetrasJaDigitadas(
    ControladorDeLetrasJaDigitadas controladorDeLetrasJaDigitadas)
    throws Exception 
    {
        // copiar c.letrasJaDigitadas em this.letrasJaDigitadas

        if (controladorDeLetrasJaDigitadas==null)
            throw new Exception ("Controlador ausente!");

        this.letrasJaDigitadas = controladorDeLetrasJaDigitadas.letrasJaDigitadas;
    }

    public Object clone ()
    {
        // criar uma c�pia do this com o construtor de c�pia e retornar
        
        ControladorDeLetrasJaDigitadas ret = null;

        try 
        {
            ret = new ControladorDeLetrasJaDigitadas(this);
        }
        catch (Exception e)
        {}

        return ret;
    }
}
