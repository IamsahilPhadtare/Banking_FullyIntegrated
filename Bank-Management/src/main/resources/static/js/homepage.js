function scrollToSection(sectionId) {
  const element = document.getElementById(sectionId);
  if (element) {
    element.scrollIntoView({ behavior: 'smooth' });
  }
}

function showMore(section) {
  alert(`More information about ${section} coming soon!`);
}

// Handle contact form submission
document.addEventListener('DOMContentLoaded', function() {
  const contactForm = document.getElementById('contactForm');
  if (contactForm) {
    contactForm.addEventListener('submit', function(e) {
      e.preventDefault();
      alert('Thank you for your message! We will get back to you soon.');
    });
  }

  // Add smooth scrolling navigation
  document.querySelectorAll('.nav-items').forEach(item => {
    item.addEventListener('click', function(e) {
      const section = this.getAttribute('data-section');
      
      if (section) {
        e.preventDefault(); // Only prevent default if it's an in-page scroll
        scrollToSection(section);
        
        // Update active state
        document.querySelectorAll('.nav-items').forEach(nav => nav.classList.remove('active'));
        this.classList.add('active');
      }
      // else: Let it behave like a normal link (no preventDefault)
    });
  });
});