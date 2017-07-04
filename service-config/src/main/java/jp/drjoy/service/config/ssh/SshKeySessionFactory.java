package jp.drjoy.service.config.ssh;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.util.FS;

/**
 *
 * Created by k.sumi on 6/16/2017.
 */
@SuppressWarnings("unused")
public class SshKeySessionFactory extends JschConfigSessionFactory {

    private String[] keyPaths;

    public SshKeySessionFactory(String... keyPaths) {
        this.keyPaths = keyPaths;
    }

    @Override protected void configure(OpenSshConfig.Host host, Session session) {
        // nothing special needed here
    }

    @Override protected JSch getJSch(OpenSshConfig.Host hc, FS fs) throws JSchException {
        JSch jsch = super.getJSch(hc, fs);

        jsch.removeAllIdentity();
        for (final String keyPath : keyPaths) {
            jsch.addIdentity(keyPath);
        }
        return jsch;
    }
}
